package org.example.adapter.out;

import lombok.extern.slf4j.Slf4j;
import org.example.application.domain.Impression;
import org.example.application.domain.Metrics;
import org.example.application.port.out.CalculateMetricsPort;
import org.example.application.port.out.SaveImpressionsPort;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.example.application.domain.Click;
import org.example.application.port.out.SaveClicksPort;

import java.util.List;

@Slf4j
public class MetricPersister implements
        SaveClicksPort,
        SaveImpressionsPort,
        CalculateMetricsPort {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public void saveAllClicks(List<Click> clicks) {

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            var entities = clicks.stream().map(Mapper::toClickJpaEntity).toList();
            for (var click : entities) {
                session.save(click);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                log.info(e.getMessage());
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveAllImpressions(List<Impression> impressions) {

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            var entities = impressions.stream().filter(impression -> impression.getId() != null).
                    map(Mapper::toImpressionJpaEntity).toList();

            for (var click : entities) {
                session.save(click);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                log.info(e.getMessage());
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Metrics> calculate() {

        Transaction transaction = null;
        List<Object[]> rawResultList = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            String jpql = """
                    SELECT i.appId AS appId, i.countryCode AS countryId, COUNT(i.id) AS impressions, COUNT(c.id) AS impressionsCount,
                        SUM(CASE WHEN c.revenue IS NOT NULL THEN c.revenue ELSE 0 END) AS revenue
                    FROM ImpressionJpaEntity i LEFT JOIN ClickJpaEntity c ON i.id = c.impressionId GROUP BY i.appId, i.countryCode
                    """;
            var query = session.createQuery(jpql);

            rawResultList = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return rawResultList.stream()
                .map(result -> new Metrics(
                        (Long) result[0],           // appId
                        (String) result[1],         // countryCode
                        (Long) result[2],           // impressions
                        (Long) result[3],           // clicks
                        (Double) result[4]          // revenue
                ))
                .toList();
    }
}

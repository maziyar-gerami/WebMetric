package org.example.application.service;

import jakarta.transaction.Transactional;
import org.example.adapter.out.FileWriter;
import org.example.adapter.out.MetricPersister;
import org.example.application.domain.ImpressionMetrics;
import org.example.application.port.out.CalculateImpressionMetricsPort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class CalculateImpressionMetricsService implements CalculateImpressionMetricsPort {

    MetricPersister persister = new MetricPersister();
    FileWriter writer = new FileWriter();

    @Override
    public List<ImpressionMetrics> calculateImpressionMetrics() {
        List<ImpressionMetrics> impressionMetrics  = persister.calculateImpressionMetrics();

        List<ImpressionMetrics> topImpressionMetrics = impressionMetrics.stream()
                .filter(e -> e.getRevenuePerImpression() != null)
                .sorted(Comparator.comparingDouble(ImpressionMetrics::getRevenuePerImpression).reversed())
                .limit(5)
                .collect(Collectors.toList());

        writer.write(topImpressionMetrics, "topImpressionMetrics");
        return impressionMetrics;
    }
}

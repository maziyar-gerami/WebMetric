package org.example.application.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.adapter.out.FileWriter;
import org.example.adapter.out.MetricPersister;
import org.example.application.domain.Click;
import org.example.application.domain.Impression;
import org.example.application.domain.Metrics;
import org.example.application.port.in.CalculateMetricsUseCase;

import java.util.List;

public class CalculateMetricsService implements CalculateMetricsUseCase {

    @Override
    public void calculateMetrics(Param param) {
        MetricPersister persister = new MetricPersister();
        FileWriter writer = new FileWriter();
        List<Click> clicks = null;
        List<Impression> impressions = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            clicks = objectMapper.readValue(param.getClicks().toString(), new TypeReference<>(){});
            impressions = objectMapper.readValue(param.getImpressions().toString(), new TypeReference<>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        persister.saveAllClicks(clicks);
        persister.saveAllImpressions (impressions);
        List<Metrics> metrics = persister.calculate();
        writer.write(metrics);
    }
}

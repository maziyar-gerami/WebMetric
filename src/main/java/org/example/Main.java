package org.example;

import org.example.adapter.in.CalculateMetricsFileReader;
import org.example.application.service.CalculateImpressionMetricsService;
import org.example.application.service.CalculateMetricsService;

public class Main {
    public static void main(String[] args) {
        CalculateMetricsService calculateMetricsService = new CalculateMetricsService();

        CalculateMetricsFileReader calculator = new CalculateMetricsFileReader(calculateMetricsService );

        calculator.calculateMetricsFileReader();

        CalculateImpressionMetricsService calculateImpressionMetricsService = new CalculateImpressionMetricsService();
        calculateImpressionMetricsService.calculateImpressionMetrics();
    }
}
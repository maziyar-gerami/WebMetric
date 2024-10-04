package org.example.application.port.out;

import org.example.application.domain.ImpressionMetrics;

import java.util.List;

public interface CalculateImpressionMetricsPort {

    List<ImpressionMetrics> calculateImpressionMetrics();
}

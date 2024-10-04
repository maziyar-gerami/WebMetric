package org.example.application.port.out;

import org.example.application.domain.Metrics;

import java.util.List;

public interface CalculateMetricsFileWriter {

    void write(List<Metrics> metrics);
}

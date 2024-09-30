package org.example.application.port.in;

import org.json.JSONArray;

import java.util.Optional;

public interface CalculateMetricsUseCase {

    void calculateMetrics(Param param);

    class Param {

        JSONArray impressions;

        JSONArray clicks;

        public Param(JSONArray impressions, JSONArray clicks) {

            this.impressions = Optional.ofNullable(impressions)
                    .filter(c -> !c.isEmpty())
                    .orElseThrow(() -> new RuntimeException("Impressions cannot be null or empty"));

            this.clicks = Optional.ofNullable(clicks)
                    .filter(c -> !c.isEmpty())
                    .orElseThrow(() -> new RuntimeException("Clicks cannot be null or empty"));
        }
    }
}

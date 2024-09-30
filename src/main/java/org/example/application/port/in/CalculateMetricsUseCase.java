package org.example.application.port.in;

import org.json.JSONObject;

import java.util.Optional;

public interface CalculateMetricsUseCase {

    void calculateMetrics(Param param);

    class Param {

        JSONObject impressions;

        JSONObject clicks;

        public Param(JSONObject impressions, JSONObject clicks) {

            this.impressions = Optional.ofNullable(impressions)
                    .filter(c -> !c.isEmpty())
                    .orElseThrow(() -> new RuntimeException("Impressions cannot be null or empty"));

            this.clicks = Optional.ofNullable(clicks)
                    .filter(c -> !c.isEmpty())
                    .orElseThrow(() -> new RuntimeException("Clicks cannot be null or empty"));
        }
    }
}

package org.example.adapter.in;

import org.example.application.port.in.CalculateMetricsUseCase;
import org.json.JSONArray;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CalculateMetricsFileReader {

    String clicksFileName = "clicks.json";
    String impressionsFileName = "impressions.json";

    private final CalculateMetricsUseCase calculateMetricsUseCase;

    public CalculateMetricsFileReader(CalculateMetricsUseCase calculateMetricsUseCase) {
        this.calculateMetricsUseCase = calculateMetricsUseCase;
    }

    public void calculateMetricsFileReader() {
        JSONArray clicks;
        JSONArray impressions;


        try {
            InputStream clicksInputStream = getClass().getClassLoader().getResourceAsStream(clicksFileName);
            String jsonContent = new String(clicksInputStream.readAllBytes(), StandardCharsets.UTF_8);
            clicks = new JSONArray(jsonContent);
        } catch (Exception e) {
            clicks = null;
        }

        try {
            InputStream impressionsStream = getClass().getClassLoader().getResourceAsStream(impressionsFileName);
            String jsonContent = new String(impressionsStream.readAllBytes(), StandardCharsets.UTF_8);
            impressions = new JSONArray(jsonContent);
        } catch (Exception e) {
            impressions = null;
        }
        calculateMetricsUseCase.calculateMetrics(new CalculateMetricsUseCase.Param(impressions, clicks));
    }

}

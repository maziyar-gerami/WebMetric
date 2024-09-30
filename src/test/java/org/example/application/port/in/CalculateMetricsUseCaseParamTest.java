package org.example.application.port.in;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculateMetricsUseCaseParamTest {

    @Test
    public void testMetricsUseCaseParam_impressionsIsNull_throwsException() {
        var clicks = new JSONArray().put(new JSONObject("key", "value"));
        var throwable = assertThrows(RuntimeException.class, () -> new CalculateMetricsUseCase.Param(null, clicks));
        assertEquals("Impressions cannot be null or empty", throwable.getMessage());
    }

    @Test
    public void testMetricsUseCaseParam_clicksIsNull_throwsException() {
        var impressions = new JSONArray().put(new JSONObject("key", "value"));
        var throwable = assertThrows(RuntimeException.class, () -> new CalculateMetricsUseCase.Param(impressions, null));
        assertEquals("Clicks cannot be null or empty", throwable.getMessage());
    }
}
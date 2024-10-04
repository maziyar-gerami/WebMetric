package org.example.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ImpressionMetrics {

    private Long appId;
    private String countryCode;
    private Long impressions;
    private Double revenuePerImpression;
}

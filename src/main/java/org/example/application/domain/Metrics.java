package org.example.application.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metrics {

    private Long appId;
    private String countryCode;
    private Long impressions;
    private  Long clicks;
    private Double revenue;
}

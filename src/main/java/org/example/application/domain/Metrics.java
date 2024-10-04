package org.example.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Metrics {

    private Long appId;
    private String countryCode;
    private Long impressions;
    private  Long clicks;
    private Double revenue;

}

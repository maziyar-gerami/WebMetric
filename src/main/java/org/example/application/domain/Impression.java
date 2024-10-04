package org.example.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Impression {

    UUID id;

    @JsonProperty("app_id")
    Long appId;

    @JsonProperty("advertiser_id")
    Long advertiserId;

    @JsonProperty("country_code")
    String countryCode;
}

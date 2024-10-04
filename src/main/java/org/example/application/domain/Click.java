package org.example.application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Click {

    UUID id;

    @JsonProperty("impression_id")
    UUID impressionId;

    Double revenue;
}

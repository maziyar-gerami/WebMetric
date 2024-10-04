package org.example.adapter.out;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.application.domain.Click;
import org.example.application.domain.Impression;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mapper {

    static ClickJpaEntity toClickJpaEntity(Click click) {
        return new ClickJpaEntity(UUID.randomUUID().toString(), click.getImpressionId().toString(), click.getRevenue());
    }

    static ImpressionJpaEntity toImpressionJpaEntity(Impression impression) {
        return new ImpressionJpaEntity(UUID.randomUUID().toString(), impression.getId().toString(), impression.getAppId(), impression.getAdvertiserId(), impression.getCountryCode());
    }
}

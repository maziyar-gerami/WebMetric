package org.example.adapter.out;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "Impressions" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ImpressionJpaEntity {

    @Id
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    String id;

    @Column(name = "app_id")
    Long appId;

    @Column(name = "advertise_id")
    Long advertiseId;

    @Column(name = "country_code")
    String countryCode;

}

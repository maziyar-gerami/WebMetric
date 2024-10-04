package org.example.adapter.out;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "Clicks" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClickJpaEntity {

    @Id
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    String id;

    @Column(name = "impression_id")
    String impressionId;

    @Column (name = "revenue")
    Double revenue;
}

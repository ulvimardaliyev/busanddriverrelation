package az.busdriver.busanddriverrelation.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusRoad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long roadId;
    String startPoint;
    String endPoint;
    double roadLength;
    @JsonIgnore
    @OneToOne(mappedBy = "busRoad")
    Bus bus;
}

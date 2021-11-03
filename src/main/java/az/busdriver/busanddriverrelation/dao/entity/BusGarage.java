package az.busdriver.busanddriverrelation.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class BusGarage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long busGarageId;

    double busGarageArea;

    @JsonIgnore
    @OneToMany(mappedBy = "busGarages")
    List<Bus> buses;
}

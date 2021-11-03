package az.busdriver.busanddriverrelation.dao.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "busId")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long busId;
    String busModel;
    String manufacturer;
    int seatCount;
    boolean hasElectricEngine;
    @ManyToMany
    @JoinTable(name = "bus_busdriver",
            joinColumns = @JoinColumn(name = "busId", referencedColumnName = "busId"),
            inverseJoinColumns = @JoinColumn(name = "busDriverId", referencedColumnName = "busDriverId"))
    List<BusDriver> busDrivers;

    @ManyToOne
    @JoinColumn(name = "busGarageId", referencedColumnName = "busGarageId")
    BusGarage busGarages;
}

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bus_id")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long bus_id;
    String busModel;
    String manufacturer;
    int seatCount;
    boolean hasElectricEngine;
    @ManyToMany
    @JoinTable(name = "bus_busdriver", joinColumns = @JoinColumn(name = "bus_id", referencedColumnName = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "driver_id"))
    List<BusDriver> busDrivers;
}

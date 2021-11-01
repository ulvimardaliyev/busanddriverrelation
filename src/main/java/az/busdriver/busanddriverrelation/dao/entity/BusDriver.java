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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "driver_id")
public class BusDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long driver_id;
    String driverName;
    String driverSurname;
    ExperienceLevel experienceLevel;
    @ManyToMany(mappedBy = "busDrivers")
    List<Bus> buses;
}

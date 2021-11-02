package az.busdriver.busanddriverrelation.dto.response;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.entity.ExperienceLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusDriverResponseDto {
    long busDriverId;
    String driverName;
    String driverSurname;
    ExperienceLevel experienceLevel;
    List<Bus> buses;
}

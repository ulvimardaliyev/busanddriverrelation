package az.busdriver.busanddriverrelation.dto.request;

import az.busdriver.busanddriverrelation.dao.entity.ExperienceLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusDriverRequestDto {
    String driverName;
    String driverSurname;
    ExperienceLevel experienceLevel;
}

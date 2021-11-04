package az.busdriver.busanddriverrelation.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusRoadRequestDto {
    String startPoint;
    String endPoint;
    double roadLength;
}

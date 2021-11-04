package az.busdriver.busanddriverrelation.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusRoadResponseDto {
    Long roadId;
    String startPoint;
    String endPoint;
    double roadLength;
}

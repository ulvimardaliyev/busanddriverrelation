package az.busdriver.busanddriverrelation.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusRequestDto {

    String busModel;
    String manufacturer;
    int seatCount;
    boolean hasElectricEngine;
    List<Long> busDriversId;
}

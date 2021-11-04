package az.busdriver.busanddriverrelation.dto.response;

import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dao.entity.BusGarage;
import az.busdriver.busanddriverrelation.dao.entity.BusRoad;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusResponseDto {
    long busId;
    String busModel;
    String manufacturer;
    int seatCount;
    boolean hasElectricEngine;
    List<BusDriver> busDrivers;
    BusGarage busGarages;
    BusRoad busRoad;
}

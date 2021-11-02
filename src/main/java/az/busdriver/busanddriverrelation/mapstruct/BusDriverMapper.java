package az.busdriver.busanddriverrelation.mapstruct;

import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dto.response.BusDriverResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusDriverMapper {
    List<BusDriverResponseDto> convertAllBusDriverToBusDriverResponse(List<BusDriver> allBusDriver);

    BusDriverResponseDto convertBusDriverToBusDriverResponse(BusDriver busDriver);
}

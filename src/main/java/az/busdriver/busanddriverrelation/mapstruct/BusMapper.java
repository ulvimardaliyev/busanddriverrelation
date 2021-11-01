package az.busdriver.busanddriverrelation.mapstruct;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dto.request.BusRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusMapper {

    List<BusResponseDto> allBusToResponseDto(List<Bus> allBuses);

    BusResponseDto busToResponseDto(Bus bus);

    @Mapping(target = "busDrivers", source = "driversList")
    Bus requestToBusDao(BusRequestDto busRequestDto, List<BusDriver> driversList);


}

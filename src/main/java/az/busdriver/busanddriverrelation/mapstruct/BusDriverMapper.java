package az.busdriver.busanddriverrelation.mapstruct;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dto.request.BusDriverRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusDriverResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusDriverMapper {

    List<BusDriverResponseDto> allBusDriverToDto(List<BusDriver> drivers);

    BusDriverResponseDto busDriverResponseDto(BusDriver busDriver);

    @Mapping(target = "buses", source = "allBusesList")
    BusDriver requestToDao(BusDriverRequestDto busDriverRequestDto, List<Bus> allBusesList);

}

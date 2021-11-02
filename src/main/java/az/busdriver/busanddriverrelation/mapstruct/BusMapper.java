package az.busdriver.busanddriverrelation.mapstruct;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dto.response.BusResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusMapper {
    //@Mapping(target = "busId", source = "busId")
    List<BusResponseDto> convertAllBusToBusResponse(List<Bus> buses);

    //@Mapping(target = "busId", source = "busId")
    BusResponseDto convertBusToBusResponseDto(Bus bus);

}

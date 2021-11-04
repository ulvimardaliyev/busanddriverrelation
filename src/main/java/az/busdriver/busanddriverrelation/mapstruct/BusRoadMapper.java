package az.busdriver.busanddriverrelation.mapstruct;

import az.busdriver.busanddriverrelation.dao.entity.BusRoad;
import az.busdriver.busanddriverrelation.dto.request.BusRoadRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusRoadResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusRoadMapper {

    List<BusRoadResponseDto> busRoadToResponseDto(List<BusRoad> busRoads);

    BusRoadResponseDto busToResponseDto(BusRoad busRoad);

    //@Mapping(target = "bus", source = "insertedBus")
    BusRoad busRoadRequestToBusRoad(BusRoadRequestDto busRoadRequestDto);
}

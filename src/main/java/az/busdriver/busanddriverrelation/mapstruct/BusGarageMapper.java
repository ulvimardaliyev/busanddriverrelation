package az.busdriver.busanddriverrelation.mapstruct;

import az.busdriver.busanddriverrelation.dao.entity.BusGarage;
import az.busdriver.busanddriverrelation.dto.response.BusGarageResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusGarageMapper {

    List<BusGarageResponseDto> busGarageToResponse(List<BusGarage> busGarages);

    BusGarageResponseDto busGarageToBusGarageResponse(BusGarage busGarage);

}

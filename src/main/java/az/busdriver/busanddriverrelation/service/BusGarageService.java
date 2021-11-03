package az.busdriver.busanddriverrelation.service;

import az.busdriver.busanddriverrelation.dto.request.BusGarageRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusGarageResponseDto;

import java.util.List;

public interface BusGarageService {
    List<BusGarageResponseDto> getAllBusGarage();

    BusGarageResponseDto getBusGarageById(Long busGarageId);

    void deleteGarageById(Long busGarageId);

    BusGarageResponseDto addNewBusGarage(BusGarageRequestDto busGarageRequestDto);


}

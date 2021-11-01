package az.busdriver.busanddriverrelation.service;

import az.busdriver.busanddriverrelation.dto.request.BusRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusResponseDto;

import java.util.List;

public interface BusService {

    List<BusResponseDto> getAllBusDrivers();

    BusResponseDto getBusById(long busId);

    long addNewBus(BusRequestDto busRequestDto);

    void deleteBus(long busId);
}

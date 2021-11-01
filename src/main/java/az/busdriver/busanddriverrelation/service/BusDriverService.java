package az.busdriver.busanddriverrelation.service;

import az.busdriver.busanddriverrelation.dto.request.BusDriverRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusDriverResponseDto;

import java.util.List;

public interface BusDriverService {

    List<BusDriverResponseDto> getAllBusDrivers();

    BusDriverResponseDto getBusDriver(long id);

    long addNewBusDriver(BusDriverRequestDto driverRequestDto);

    void deleteBusDriver(long busDriverId);

}

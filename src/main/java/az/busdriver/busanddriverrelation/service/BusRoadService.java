package az.busdriver.busanddriverrelation.service;

import az.busdriver.busanddriverrelation.dto.request.BusRoadRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusRoadResponseDto;

import java.util.List;

public interface BusRoadService {

    List<BusRoadResponseDto> getAllBusRoads();

    BusRoadResponseDto getBusRoadById(Long busRoadId);

    void deleteBusRoadById(Long busRoadId);

    long saveNewBusRoad(BusRoadRequestDto roadRequestDto);
}

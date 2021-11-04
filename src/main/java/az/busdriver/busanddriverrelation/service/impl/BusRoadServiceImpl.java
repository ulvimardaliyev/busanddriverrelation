package az.busdriver.busanddriverrelation.service.impl;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.entity.BusRoad;
import az.busdriver.busanddriverrelation.dao.repository.BusRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRoadRepository;
import az.busdriver.busanddriverrelation.dto.request.BusRoadRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusRoadResponseDto;
import az.busdriver.busanddriverrelation.mapstruct.BusRoadMapper;
import az.busdriver.busanddriverrelation.service.BusRoadService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BusRoadServiceImpl implements BusRoadService {

    BusRepository busRepository;
    BusRoadRepository busRoadRepository;
    BusRoadMapper busRoadMapper;

    @Override
    public List<BusRoadResponseDto> getAllBusRoads() {
        List<BusRoad> allBusRoad = busRoadRepository.findAll();
        return busRoadMapper.busRoadToResponseDto(allBusRoad);
    }

    @Override
    public BusRoadResponseDto getBusRoadById(Long busRoadId) {
        BusRoad currentBusRoad = busRoadRepository.findBusRoadByRoadId(busRoadId);
        var busRoad = busRoadRepository.save(currentBusRoad);
        return busRoadMapper.busToResponseDto(busRoad);
    }

    @Transactional
    @Override
    public void deleteBusRoadById(Long busRoadId) {
        BusRoad currentBusRoad = busRoadRepository.findBusRoadByRoadId(busRoadId);
        Bus bus = currentBusRoad.getBus();
        bus.setBusRoad(null);
        busRepository.save(bus);
        busRoadRepository.deleteBusRoadByRoadId(busRoadId);
    }

    @Override
    public long saveNewBusRoad(BusRoadRequestDto roadRequestDto) {

        BusRoad busRoad = busRoadMapper.busRoadRequestToBusRoad(roadRequestDto);
        long id = busRoadRepository.save(busRoad).getRoadId();
        return id;
    }
}

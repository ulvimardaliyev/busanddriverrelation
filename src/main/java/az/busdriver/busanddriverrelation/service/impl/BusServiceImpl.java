package az.busdriver.busanddriverrelation.service.impl;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dao.entity.BusGarage;
import az.busdriver.busanddriverrelation.dao.entity.BusRoad;
import az.busdriver.busanddriverrelation.dao.repository.BusDriverRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusGarageRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRoadRepository;
import az.busdriver.busanddriverrelation.dto.request.BusRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusResponseDto;
import az.busdriver.busanddriverrelation.mapstruct.BusMapper;
import az.busdriver.busanddriverrelation.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusRepository busRepository;
    private final BusMapper busMapper;
    private final BusDriverRepository busDriverRepository;
    private final BusGarageRepository busGarageRepository;
    private final BusRoadRepository busRoadRepository;

    @Override
    public List<BusResponseDto> getAllBuses() {
        var allBuses = busRepository.findAll();
        return busMapper.convertAllBusToBusResponse(allBuses);
    }

    @Override
    public BusResponseDto getBusById(long busId) {
        var bus = busRepository.findBusByBusId(busId);
        return busMapper.convertBusToBusResponseDto(bus);
    }

    @Override
    public long addNewBus(BusRequestDto busRequestDto) {
        BusRoad busRoad = busRoadRepository.findBusRoadByRoadId(busRequestDto.getBusRoadId());
        Bus bus = busMapper.convertRequestToBus(busRequestDto, busRoad);
        var id = busRepository.save(bus).getBusId();
        return id;
    }

    @Override
    public void deleteBus(long busId) {
        Bus currentBus = busRepository.findBusByBusId(busId);
        currentBus.getBusDrivers().clear();
        busRepository.deleteBusByBusId(busId);
    }

    @Override
    public BusResponseDto addBusDriverToBus(Long busId, Long busDriverId) {
        Bus currentBus = busRepository.findBusByBusId(busId);
        BusDriver currentDriver = busDriverRepository.findBusDriverByBusDriverId(busDriverId);
        if (currentBus.getBusDrivers() == null || currentBus.getBusDrivers().isEmpty()) {
            List<BusDriver> driverList = new ArrayList<>();
            driverList.add(currentDriver);
            currentBus.setBusDrivers(driverList);
        } else if (!currentBus.getBusDrivers().contains(currentDriver)) {
            currentBus.getBusDrivers().add(currentDriver);
        }
        var updatedBusWithDriver = busRepository.save(currentBus);
        return busMapper.convertBusToBusResponseDto(updatedBusWithDriver);
    }

    @Override
    public BusResponseDto addBusToGarage(Long busGarageId, Long busId) {
        BusGarage busGarage = busGarageRepository.findBusGarageByBusGarageId(busGarageId);
        Bus bus = busRepository.findBusByBusId(busId);

        bus.setBusGarages(busGarage);
        busRepository.save(bus);
        return busMapper.convertBusToBusResponseDto(bus);
    }
}

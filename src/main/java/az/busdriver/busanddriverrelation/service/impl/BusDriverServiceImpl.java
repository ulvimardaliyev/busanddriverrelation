package az.busdriver.busanddriverrelation.service.impl;

import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dao.repository.BusDriverRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRepository;
import az.busdriver.busanddriverrelation.dto.request.BusDriverRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusDriverResponseDto;
import az.busdriver.busanddriverrelation.mapstruct.BusDriverMapper;
import az.busdriver.busanddriverrelation.service.BusDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class BusDriverServiceImpl implements BusDriverService {
    private final BusRepository busRepository;
    private final BusDriverMapper busDriverMapper;
    private final BusDriverRepository busDriverRepository;

    @Override
    public List<BusDriverResponseDto> getAllBusDrivers() {
        var allBusDrivers = busDriverRepository.findAll();
        return busDriverMapper.convertAllBusDriverToBusDriverResponse(allBusDrivers);
    }

    @Override
    public BusDriverResponseDto getBusDriver(long id) {
        var busDriver = busDriverRepository.findBusDriverByBusDriverId(id);
        return busDriverMapper.convertBusDriverToBusDriverResponse(busDriver);
    }

    @Override
    public long addNewBusDriver(BusDriverRequestDto driverRequestDto) {
        BusDriver busDriver = BusDriver
                .builder()
                .driverSurname(driverRequestDto.getDriverSurname())
                .driverName(driverRequestDto.getDriverName())
                .experienceLevel(driverRequestDto.getExperienceLevel())
                .build();
        return busDriverRepository.save(busDriver).getBusDriverId();
    }

    @Override
    public void deleteBusDriver(long busDriverId) {
        busDriverRepository.deleteBusDriverByBusDriverId(busDriverId);
    }

    @Override
    public void addBusToBusDriver(Long busDriverId, Long busId) {

    }
}

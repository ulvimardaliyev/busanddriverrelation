package az.busdriver.busanddriverrelation.service.impl;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.repository.BusDriverRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRepository;
import az.busdriver.busanddriverrelation.dto.request.BusDriverRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusDriverResponseDto;
import az.busdriver.busanddriverrelation.mapstruct.BusDriverMapper;
import az.busdriver.busanddriverrelation.service.BusDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusDriverServiceImpl implements BusDriverService {
    private final BusRepository busRepository;
    private final BusDriverMapper busDriverMapper;
    private final BusDriverRepository busDriverRepository;


    @Override
    public List<BusDriverResponseDto> getAllBusDrivers() {
        var list = busDriverRepository.findAll();
        return busDriverMapper.allBusDriverToDto(list);
    }

    @Override
    public BusDriverResponseDto getBusDriver(long id) {
        var busDriver = busDriverRepository.findById(id).get();
        return busDriverMapper.busDriverResponseDto(busDriver);
    }

    @Override
    public long addNewBusDriver(BusDriverRequestDto driverRequestDto) {
        var busIdList = driverRequestDto.getBusesId();
        var allBuses = busRepository.findAll();
        List<Bus> buses =
                allBuses
                        .stream()
                        .filter(
                                bus ->
                                        busIdList.stream().anyMatch(id -> id > 0)
                        )
                        .collect(Collectors.toList());
        var busDriver = busDriverMapper.requestToDao(driverRequestDto, buses);
        return busDriverRepository.save(busDriver).getDriver_id();
    }

    @Override
    public void deleteBusDriver(long busDriverId) {
        busDriverRepository.deleteById(busDriverId);
    }
}

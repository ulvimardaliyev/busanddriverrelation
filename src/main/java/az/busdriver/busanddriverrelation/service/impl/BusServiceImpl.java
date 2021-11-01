package az.busdriver.busanddriverrelation.service.impl;

import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dao.repository.BusDriverRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRepository;
import az.busdriver.busanddriverrelation.dto.request.BusRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusResponseDto;
import az.busdriver.busanddriverrelation.mapstruct.BusMapper;
import az.busdriver.busanddriverrelation.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusRepository busRepository;
    private final BusMapper busMapper;
    private final BusDriverRepository busDriverRepository;

    @Override
    public List<BusResponseDto> getAllBusDrivers() {
        var allBuses = busRepository.findAll();
        var allBuses1 = busMapper.allBusToResponseDto(allBuses);
        return allBuses1;
    }

    @Override
    public BusResponseDto getBusById(long busId) {
        var bus = busRepository.findById(busId).get();
        return busMapper.busToResponseDto(bus);
    }

    @Override
    public long addNewBus(BusRequestDto busRequestDto) {
        var list = busRequestDto.getBusDriversId();
        var allBusDrivers = busDriverRepository.findAll();


        List<BusDriver> drivers =
                allBusDrivers
                        .stream()
                        .filter(
                                busDriver ->
                                        list.stream().anyMatch(id -> id > 0)
                        )
                        .collect(Collectors.toList());

        var bus = busMapper.requestToBusDao(busRequestDto, drivers);
        return busRepository.save(bus).getBus_id();
    }

    @Override
    public void deleteBus(long busId) {
        busRepository.deleteById(busId);
    }
}

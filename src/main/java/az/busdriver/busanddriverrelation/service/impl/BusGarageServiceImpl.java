package az.busdriver.busanddriverrelation.service.impl;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.entity.BusGarage;
import az.busdriver.busanddriverrelation.dao.repository.BusGarageRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRepository;
import az.busdriver.busanddriverrelation.dto.request.BusGarageRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusGarageResponseDto;
import az.busdriver.busanddriverrelation.mapstruct.BusGarageMapper;
import az.busdriver.busanddriverrelation.service.BusGarageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusGarageServiceImpl implements BusGarageService {
    BusRepository busRepository;
    BusGarageRepository busGarageRepository;
    BusGarageMapper busGarageMapper;

    @Override
    public List<BusGarageResponseDto> getAllBusGarage() {
        List<BusGarage> busGarages = busGarageRepository.findAll();
        return busGarageMapper.busGarageToResponse(busGarages);
    }

    @Override
    public BusGarageResponseDto getBusGarageById(Long busGarageId) {
        BusGarage busGarage = busGarageRepository.findBusGarageByBusGarageId(busGarageId);
        return busGarageMapper.busGarageToBusGarageResponse(busGarage);
    }

    @Transactional
    @Override
    public void deleteGarageById(Long busGarageId) {
        BusGarage busGarage = busGarageRepository.findBusGarageByBusGarageId(busGarageId);
        List<Bus> allBuses = busRepository.findAll();
        allBuses.forEach(bus -> bus.setBusGarages(null));
        busGarageRepository.deleteBusGarageByBusGarageId(busGarageId);
    }

    @Override
    public BusGarageResponseDto addNewBusGarage(BusGarageRequestDto busGarageRequestDto) {
        BusGarage busGarage = BusGarage
                .builder()
                .busGarageArea(busGarageRequestDto.getBusGarageArea())
                .build();
        busGarageRepository.save(busGarage);
        BusGarageResponseDto responseDto = busGarageMapper.busGarageToBusGarageResponse(busGarage);
        return responseDto;
    }

}

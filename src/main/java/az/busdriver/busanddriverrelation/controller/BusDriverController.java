package az.busdriver.busanddriverrelation.controller;

import az.busdriver.busanddriverrelation.dto.request.BusDriverRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusDriverResponseDto;
import az.busdriver.busanddriverrelation.service.BusDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class BusDriverController {

    private final BusDriverService busDriverService;

    @GetMapping("busdrivers")
    public List<BusDriverResponseDto> getAllBusDrivers() {
        return busDriverService.getAllBusDrivers();
    }

    @GetMapping("busdrivers/{busDriverId}")
    public BusDriverResponseDto getBusDriverById(@PathVariable long busDriverId) {
        return busDriverService.getBusDriver(busDriverId);
    }

    @DeleteMapping("busdrivers/{busDriverId}")
    public void deleteBusDriver(@PathVariable long busDriverId) {
        busDriverService.deleteBusDriver(busDriverId);
    }

    @PostMapping("busdrivers")
    public long newDriver(@RequestBody BusDriverRequestDto busDriverRequestDto) {
        return busDriverService.addNewBusDriver(busDriverRequestDto);
    }

    //TODO write PUT Method
}

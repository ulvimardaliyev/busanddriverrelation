package az.busdriver.busanddriverrelation.controller;

import az.busdriver.busanddriverrelation.dto.request.BusRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusResponseDto;
import az.busdriver.busanddriverrelation.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @GetMapping("buses")
    public List<BusResponseDto> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("buses/{busId}")
    public BusResponseDto getBus(@PathVariable long busId) {
        return busService.getBusById(busId);
    }

    @DeleteMapping("buses/{busId}")
    public void delete(@PathVariable long busId) {
        busService.deleteBus(busId);
    }

    @PostMapping("buses")
    public long newBusId(@RequestBody BusRequestDto busRequestDto) {
        return busService.addNewBus(busRequestDto);
    }
    //TODO write PUT Method

    @PutMapping("buses/{busId}/driver/{driverId}")
    public BusResponseDto addDriverToBus(@PathVariable Long busId,
                                         @PathVariable Long driverId) {
        return busService.addBusDriverToBus(busId, driverId);
    }

}

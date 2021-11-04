package az.busdriver.busanddriverrelation.controller;

import az.busdriver.busanddriverrelation.dto.request.BusRoadRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusRoadResponseDto;
import az.busdriver.busanddriverrelation.service.BusRoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class BusRoadController {

    private final BusRoadService busRoadService;

    @GetMapping("busroads")
    public List<BusRoadResponseDto> getAllBusRoads() {
        return busRoadService.getAllBusRoads();
    }

    @GetMapping("busroads/{busRoadId}")
    public BusRoadResponseDto getBusRoad(@PathVariable Long busRoadId) {
        return busRoadService.getBusRoadById(busRoadId);
    }

    @PostMapping("busroads")
    public long addNewBusRoad(@RequestBody BusRoadRequestDto busRoadRequestDto) {
        return busRoadService.saveNewBusRoad(busRoadRequestDto);
    }

    @DeleteMapping("busroads/{busRoadId}")
    public void deleteBusRoad(@PathVariable Long busRoadId) {
        busRoadService.deleteBusRoadById(busRoadId);
    }
}

package az.busdriver.busanddriverrelation.controller;

import az.busdriver.busanddriverrelation.dto.request.BusGarageRequestDto;
import az.busdriver.busanddriverrelation.dto.response.BusGarageResponseDto;
import az.busdriver.busanddriverrelation.service.BusGarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class BusGarageController {

    private final BusGarageService busGarageService;


    @GetMapping("busgarages")
    public List<BusGarageResponseDto> getAllBusGarages() {
        return busGarageService.getAllBusGarage();
    }

    @GetMapping("busgarages/{busGarageID}")
    public BusGarageResponseDto busGarageResponseDto(@PathVariable Long busGarageID) {
        return busGarageService.getBusGarageById(busGarageID);
    }

    @PostMapping("busgarages")
    public BusGarageResponseDto busGarageResponseDto(
            @RequestBody BusGarageRequestDto busGarageRequestDto) {
        return busGarageService.addNewBusGarage(busGarageRequestDto);
    }

    @DeleteMapping("busgarages/{busGarageId}")
    public void deleteBusGarage(@PathVariable Long busGarageId) {
        busGarageService.deleteGarageById(busGarageId);
    }


}

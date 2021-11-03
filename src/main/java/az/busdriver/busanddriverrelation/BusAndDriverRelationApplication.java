package az.busdriver.busanddriverrelation;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import az.busdriver.busanddriverrelation.dao.entity.ExperienceLevel;
import az.busdriver.busanddriverrelation.dao.repository.BusDriverRepository;
import az.busdriver.busanddriverrelation.dao.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BusAndDriverRelationApplication implements CommandLineRunner {

    @Autowired
    private BusDriverRepository busDriverRepository;
    @Autowired
    private BusRepository busRepository;

    public static void main(String[] args) {
        SpringApplication.run(BusAndDriverRelationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<BusDriver> busDriverList = new ArrayList<>();
        List<Bus> busList = new ArrayList<>();

        Bus bus = Bus
                .builder()
                .manufacturer("Mercedes")
                .seatCount(24)
                .busModel("Vita")
                .hasElectricEngine(true)
                .busId(1L)
                .build();
        BusDriver busDriver = BusDriver
                .builder()
                .driverSurname("Mardaliyev")
                .driverName("Ulvi")
                .experienceLevel(ExperienceLevel.MIDDLE)
                .busDriverId(1L)
                .build();
        busDriverList.add(busDriver);
        busDriver.setBuses(busList);
        busDriverRepository.save(busDriver);
        busList.add(bus);
        bus.setBusDrivers(busDriverList);

        busRepository.save(bus);
    }
}

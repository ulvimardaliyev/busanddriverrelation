package az.busdriver.busanddriverrelation.dao.repository;

import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusDriverRepository extends CrudRepository<BusDriver, Long> {

    @Override
    List<BusDriver> findAll();

    BusDriver findBusDriverByBusDriverId(long driverId);

    void deleteBusDriverByBusDriverId(long driverId);
}

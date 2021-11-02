package az.busdriver.busanddriverrelation.dao.repository;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {

    Bus findBusByBusId(long busId);

    @Override
    List<Bus> findAll();

    void deleteBusByBusId(long driverId);
}

package az.busdriver.busanddriverrelation.dao.repository;

import az.busdriver.busanddriverrelation.dao.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    //Bus findById(long busId);

   /* @Override
    List<Bus> findAll();

    void deleteByBus_id(long driverId);*/
}

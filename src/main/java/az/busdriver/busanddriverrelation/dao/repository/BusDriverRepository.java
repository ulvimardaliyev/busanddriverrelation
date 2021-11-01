package az.busdriver.busanddriverrelation.dao.repository;

import az.busdriver.busanddriverrelation.dao.entity.BusDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusDriverRepository extends JpaRepository<BusDriver, Long> {
    /*BusDriver findByDriver_id(long driverId);

    @Override
    List<BusDriver> findAll();

    void deleteByDriver_id(long driverId);*/
}

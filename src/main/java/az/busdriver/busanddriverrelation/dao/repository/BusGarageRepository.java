package az.busdriver.busanddriverrelation.dao.repository;

import az.busdriver.busanddriverrelation.dao.entity.BusGarage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusGarageRepository extends CrudRepository<BusGarage, Long> {
    @Override
    List<BusGarage> findAll();

    BusGarage findBusGarageByBusGarageId(Long busGarageId);

    void deleteBusGarageByBusGarageId(Long busGarageId);
}

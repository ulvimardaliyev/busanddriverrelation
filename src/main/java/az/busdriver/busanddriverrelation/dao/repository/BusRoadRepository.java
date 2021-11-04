package az.busdriver.busanddriverrelation.dao.repository;

import az.busdriver.busanddriverrelation.dao.entity.BusRoad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRoadRepository extends CrudRepository<BusRoad, Long> {

    @Override
    List<BusRoad> findAll();

    BusRoad findBusRoadByRoadId(Long busRoadId);

    void deleteBusRoadByRoadId(Long busRoadId);
}

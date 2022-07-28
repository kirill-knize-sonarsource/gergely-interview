package eu.sige.daterbackend.statistic.repository;

import eu.sige.daterbackend.statistic.model.AccessData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends CrudRepository<AccessData, Long> {
}

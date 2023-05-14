package codadoor.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import codadoor.pfe.entity.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

}

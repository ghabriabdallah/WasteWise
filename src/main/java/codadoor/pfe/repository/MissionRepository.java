package codadoor.pfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import codadoor.pfe.entity.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query("SELECT m FROM Mission m JOIN FETCH m.subscription s JOIN FETCH m.driver d WHERE d.id = :driverId")
    List<Mission> findByDriverId(@Param("driverId") Long driverId);
}

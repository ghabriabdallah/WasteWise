package codadoor.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codadoor.pfe.entity.Feedback;
import codadoor.pfe.entity.Mission;
import codadoor.pfe.repository.MissionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class MissionServiceImpl implements MissionService{

	@PersistenceContext
    private EntityManager entityManager;
	
	 @Autowired
	    private MissionRepository missionRepository;
	   @Override
	    public void saveMission(Mission mission) {
	        missionRepository.save(mission);
	    }
	    @Override
		public void deleteMission(long id) {
		 missionRepository.deleteById(id);
		}

	    public Mission findMissionById(Long id) {
	        return missionRepository.findById(id).orElse(null);
	    }
	    @Override
	    public List<Mission> getAllMissions() {
	        return entityManager.createQuery(
	            "SELECT m FROM Mission m JOIN FETCH m.subscription JOIN FETCH m.driver",
	            Mission.class
	        ).getResultList();
	    }
	    @Override
	    public void updateMissionStatus(Long id, String missionStatus) {
	        Mission mission = missionRepository.findById(id).orElse(null);
	        if (mission != null) {
	            mission.setMissionStatus(missionStatus);
	            missionRepository.save(mission);
	        }
	    }
	    
	    @Override
	    public List<Mission> getMissionsByDriverId(Long driverId) {
	        return entityManager.createQuery(
	            "SELECT m FROM Mission m JOIN FETCH m.subscription s JOIN FETCH m.driver d WHERE d.id = :driverId",
	            Mission.class
	        ).setParameter("driverId", driverId)
	        .getResultList();
	    }


}

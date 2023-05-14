package codadoor.pfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codadoor.pfe.entity.Mission;
import codadoor.pfe.repository.MissionRepository;

@Service
public class MissionServiceImpl implements MissionService{

	 @Autowired
	    private MissionRepository missionRepository;

	    public void saveMission(Mission mission) {
	        missionRepository.save(mission);
	    }

	    public Mission findMissionById(Long id) {
	        return missionRepository.findById(id).orElse(null);
	    }
	    
	    
}

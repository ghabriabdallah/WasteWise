package codadoor.pfe.services;

import java.util.List;

import codadoor.pfe.entity.Mission;

public interface MissionService {
    public void saveMission(Mission mission);
    public Mission findMissionById(Long id);
	List<Mission> getAllMissions();
	List<Mission> getMissionsByDriverId(Long driverId);
	void updateMissionStatus(Long id, String missionStatus);
	void deleteMission(long id);
}


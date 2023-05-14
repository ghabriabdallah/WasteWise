package codadoor.pfe.services;

import codadoor.pfe.entity.Mission;

public interface MissionService {
    public void saveMission(Mission mission);
    public Mission findMissionById(Long id);
}


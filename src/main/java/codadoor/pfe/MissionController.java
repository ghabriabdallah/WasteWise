package codadoor.pfe;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import codadoor.pfe.entity.Feedback;
import codadoor.pfe.entity.Mission;
import codadoor.pfe.services.MissionService;

@RestController
@RequestMapping("/WasteWise")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
public class MissionController {

    @Autowired
    private MissionService missionService;

    @GetMapping(path ="Admin/AllMissions") 
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public List<Mission> getAllMissions() {
		return  missionService.getAllMissions();
	}
    
    @PostMapping("/createMission")
    public ResponseEntity<Void> createMission(@RequestBody Mission mission) {
        missionService.saveMission(mission);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable Long id) {
        Mission mission = missionService.findMissionById(id);
        if (mission == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(mission, HttpStatus.OK);
        }
    }
    @PatchMapping("/Admin/updateMissionStatus/{id}")
    public void updateMissionStatus(@PathVariable Long id, @RequestBody Mission mission) {
        Mission existingMission = missionService.findMissionById(id);
        if (existingMission != null) {
            existingMission.setMissionStatus(mission.getMissionStatus());
            missionService.saveMission(existingMission);
        }
    }

    @DeleteMapping(path="/Admin/deleteMission/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public void deleteMission(@PathVariable Long id) {
		missionService.deleteMission(id);
	}
    
    
    @GetMapping("/missionsByDriver/{driverId}")
    public ResponseEntity<List<Mission>> getMissionsByDriverId(@PathVariable Long driverId) {
        List<Mission> missions = missionService.getMissionsByDriverId(driverId);
        if (missions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(missions, HttpStatus.OK);
        }
    }


    @GetMapping("/todayMissionsByDriver/{driverId}")
    public ResponseEntity<List<Mission>> getTodayMissionsByDriverId(@PathVariable Long driverId) {
        List<Mission> todayMissions = missionService.getTodayMissionsByDriverId(driverId);
        if (todayMissions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(todayMissions, HttpStatus.OK);
        }
    }

}

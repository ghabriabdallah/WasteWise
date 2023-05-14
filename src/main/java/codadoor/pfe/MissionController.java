package codadoor.pfe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codadoor.pfe.entity.Mission;
import codadoor.pfe.services.MissionService;

@RestController
@RequestMapping("/WasteWise")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
public class MissionController {

    @Autowired
    private MissionService missionService;

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

}

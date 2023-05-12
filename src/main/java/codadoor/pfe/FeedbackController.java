package codadoor.pfe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codadoor.pfe.entity.Feedback;
import codadoor.pfe.entity.User;
import codadoor.pfe.services.FeedbackService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/WasteWise")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
@RequiredArgsConstructor
public class FeedbackController {
    
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping(path ="Admin/AllFeedbacks") 
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public List<Feedback> getAllFeedbacks() {
		return  feedbackService.getAllFeedbacks();
	}
    
    @PostMapping("/feedback")
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    @GetMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> getFeedback(@PathVariable Long id) {
    	Feedback feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }
    @DeleteMapping(path="/Admin/deleteFeedback/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public void deleteFeedback(@PathVariable Long id) {
		feedbackService.deleteFeedback(id);
	}
}


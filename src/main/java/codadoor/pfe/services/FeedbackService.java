package codadoor.pfe.services;

import java.util.List;

import codadoor.pfe.entity.Feedback;

public interface FeedbackService {
	
	Feedback saveFeedback(Feedback feedback);
	Feedback getFeedbackById(Long id);
	List<Feedback> getAllFeedbacks();
	void deleteFeedback(long id);
}

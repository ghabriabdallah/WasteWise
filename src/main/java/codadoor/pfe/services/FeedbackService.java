package codadoor.pfe.services;

import codadoor.pfe.entity.Feedback;

public interface FeedbackService {
	
	Feedback saveFeedback(Feedback feedback);
	Feedback getFeedbackById(Long id);
}

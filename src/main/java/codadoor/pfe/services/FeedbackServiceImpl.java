package codadoor.pfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codadoor.pfe.entity.Feedback;
import codadoor.pfe.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
    private FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);

	}

	@Override
	public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);

	}
	

}

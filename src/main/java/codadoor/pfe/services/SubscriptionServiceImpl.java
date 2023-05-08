package codadoor.pfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codadoor.pfe.entity.Subscription;
import codadoor.pfe.entity.User;
import codadoor.pfe.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }
    
    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }


    
}

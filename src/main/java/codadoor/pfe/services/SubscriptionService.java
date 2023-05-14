package codadoor.pfe.services;

import java.util.List;

import codadoor.pfe.entity.Subscription;

public interface SubscriptionService {
    
    Subscription saveSubscription(Subscription subscription);
    Subscription getSubscriptionById(Long id);
	List<Subscription> getAllSubscriptions();

    
}

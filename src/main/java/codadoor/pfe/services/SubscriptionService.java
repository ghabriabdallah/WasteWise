package codadoor.pfe.services;

import codadoor.pfe.entity.Subscription;

public interface SubscriptionService {
    
    Subscription saveSubscription(Subscription subscription);
    
    Subscription getSubscriptionById(Long id);
    
}

package codadoor.pfe.services;

import codadoor.pfe.entity.Subscription;
import codadoor.pfe.entity.User;

public interface SubscriptionService {
    
    Subscription saveSubscription(Subscription subscription);
    Subscription getSubscriptionById(Long id);

    
}

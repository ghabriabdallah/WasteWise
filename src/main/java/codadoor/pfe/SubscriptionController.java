package codadoor.pfe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codadoor.pfe.entity.Subscription;
import codadoor.pfe.services.SubscriptionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/WasteWise/services")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
@RequiredArgsConstructor
public class SubscriptionController {
    
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/subscription")
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
        Subscription savedSubscription = subscriptionService.saveSubscription(subscription);
        return ResponseEntity.ok(savedSubscription);
    }

    @GetMapping("/subscriptions/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable Long id) {
        Subscription subscription = subscriptionService.getSubscriptionById(id);
        return ResponseEntity.ok(subscription);
    }
}


package tn.esprit.charekyosr4twin5.Services;

import tn.esprit.charekyosr4twin5.entities.Subscription;
import java.util.List;

public interface ISubscriptionService {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    void removeSubscription(Long numSubscription);
    Subscription retrieveSubscription(Long numSubscription);
    List<Subscription> getAllSubscriptions();
}

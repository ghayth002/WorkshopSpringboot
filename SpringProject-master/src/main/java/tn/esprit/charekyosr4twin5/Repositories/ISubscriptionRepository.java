package tn.esprit.charekyosr4twin5.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.charekyosr4twin5.entities.Subscription;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
}
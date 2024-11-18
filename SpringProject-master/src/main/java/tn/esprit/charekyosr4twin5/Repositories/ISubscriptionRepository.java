package tn.esprit.charekyosr4twin5.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.charekyosr4twin5.entities.Subscription;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.util.Set;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
    Set<Subscription> findByTypeSubOrderByStartDateAsc(@Param("typeS") TypeSubscription typeSub);
}

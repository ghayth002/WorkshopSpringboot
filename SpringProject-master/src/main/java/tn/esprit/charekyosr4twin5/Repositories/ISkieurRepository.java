package tn.esprit.charekyosr4twin5.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.charekyosr4twin5.entities.Skieur;
import tn.esprit.charekyosr4twin5.entities.Subscription;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISkieurRepository extends CrudRepository <Skieur, Long> {
    @Query("SELECT s FROM Skieur s WHERE s.birthDate = :birthDate")
    List<Skieur> findByBirthDate(@Param("birthDate") LocalDate birthDate);
    Skieur findByName(String name);
    List<Skieur> findBySubscription_TypeSub(TypeSubscription typeSubscription);
    Skieur findBySubscription(Subscription subscription);
}

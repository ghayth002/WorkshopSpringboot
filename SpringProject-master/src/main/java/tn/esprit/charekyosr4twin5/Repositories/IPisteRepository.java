package tn.esprit.charekyosr4twin5.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.charekyosr4twin5.entities.Color;
import tn.esprit.charekyosr4twin5.entities.Piste;

import java.util.List;

public interface IPisteRepository extends CrudRepository<Piste, Long> {
    @Query("SELECT p FROM Piste p WHERE p.color = :color")
    List<Piste> findByColor(Color color);


}

package tn.esprit.charekyosr4twin5.Services;

import tn.esprit.charekyosr4twin5.entities.Color;
import tn.esprit.charekyosr4twin5.entities.Skieur;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISkierService {
 Skieur addSkier(Skieur skier);
 Skieur updateSkier(Skieur skieur);
 Skieur retriveSkier(Long numSkier);
 List<Skieur> retriveAll();
 void remouveSkier(Long numSkier);
    List<Skieur> findByBirthDate(LocalDate birthDate);
 List<Skieur> searchByFirstAndOrLastName(String Name);
 Skieur assignSkierToPiste(String name, Color color);
 Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);
}

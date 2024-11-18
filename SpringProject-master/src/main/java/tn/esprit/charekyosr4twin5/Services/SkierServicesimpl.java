package tn.esprit.charekyosr4twin5.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.charekyosr4twin5.Repositories.ICourseRepository;
import tn.esprit.charekyosr4twin5.Repositories.IPisteRepository;
import tn.esprit.charekyosr4twin5.Repositories.IRegistrationRepository;
import tn.esprit.charekyosr4twin5.Repositories.ISkieurRepository;
import tn.esprit.charekyosr4twin5.entities.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SkierServicesimpl implements ISkierService {

    private final ISkieurRepository skieurRepository;
    private final IPisteRepository pisteRepository;
    private final ICourseRepository courseRepository;
    private final IRegistrationRepository registrationRepository;

    @Override
    public Skieur addSkier(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkier(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur retriveSkier(Long numSkier) {
        return skieurRepository.findById(numSkier).orElse(null);
    }

    @Override
    public List<Skieur> retriveAll() {
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public void remouveSkier(Long numSkier) {
        skieurRepository.deleteById(numSkier);
    }

    @Override
    public List<Skieur> findByBirthDate(LocalDate birthDate) {
        return skieurRepository.findByBirthDate(birthDate);
    }

    @Override
    public List<Skieur> searchByFirstAndOrLastName(String name) {
        return List.of();
    }

    @Override
    public Skieur assignSkierToPiste(String name, Color color) {
        // Retrieve the Skieur entity by its name from the skieurRepository
        Skieur skieur = skieurRepository.findByName(name);

        // Check if the Skieur entity is null (not found)
        if (skieur == null) {
            // Throw a RuntimeException if the Skieur is not found
            throw new RuntimeException("Skieur not found");
        }

        // Retrieve the list of Piste entities by their color from the pisteRepository
        List<Piste> pistes = pisteRepository.findByColor(color);

        // Check if the list of Piste entities is empty (no pistes found with the specified color)
        if (pistes.isEmpty()) {
            // Throw a RuntimeException if no Piste with the specified color is found
            throw new RuntimeException("Piste with the specified color not found");
        }

        // Iterate over each Piste in the list of pistes
        for (Piste piste : pistes) {
            // Add the Piste to the Skieur's list of pistes
            skieur.getPistes().add(piste);
            // Add the Skieur to the Piste's list of skieurs
            piste.getSkieurs().add(skieur);
            // Save the updated Piste entity to the pisteRepository
            pisteRepository.save(piste);
        }

        // Save the updated Skieur entity to the skieurRepository
        skieurRepository.save(skieur);

        // Return the updated Skieur entity
        return skieur;
    }
    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse) {
        // Save the Skieur entity
        Skieur savedSkier = skieurRepository.save(skier);

        // Retrieve the Course entity by its ID
        Optional<Course> courseOpt = courseRepository.findById(numCourse);
        if (!courseOpt.isPresent()) {
            throw new RuntimeException("Course not found");
        }
        Course course = courseOpt.get();

        // Initialize the registrations set if it is null
        Set<Registration> registrations = savedSkier.getRegistrations();
        if (registrations == null) {
            registrations = new HashSet<>();
            savedSkier.setRegistrations(registrations);
        }

        // Assign the Skieur to the Course and save the Registration entities
        for (Registration r : registrations) {
            r.setSkieur(savedSkier);
            r.setCourse(course);
            registrationRepository.save(r);
        }

        return savedSkier;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription) {
        return skieurRepository.findBySubscription_TypeSub(typeSubscription);
    }


}


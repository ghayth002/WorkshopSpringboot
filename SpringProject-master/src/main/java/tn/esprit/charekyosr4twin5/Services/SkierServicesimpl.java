package tn.esprit.charekyosr4twin5.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.charekyosr4twin5.Repositories.ISkieurRepository;
import tn.esprit.charekyosr4twin5.entities.Skieur;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SkierServicesimpl implements ISkierService {
 @Autowired
    private ISkieurRepository skieurRepository;
 @Override
 public Skieur addSkier(Skieur skieur){

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
}

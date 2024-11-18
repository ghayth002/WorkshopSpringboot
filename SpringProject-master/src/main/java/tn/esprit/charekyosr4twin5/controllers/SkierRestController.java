package tn.esprit.charekyosr4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.Services.SkierServicesimpl;
import tn.esprit.charekyosr4twin5.entities.Color;
import tn.esprit.charekyosr4twin5.entities.Skieur;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skier")
public class SkierRestController {
private final SkierServicesimpl skierServices;

    @PostMapping("/add")
    public Skieur saveSkier(@RequestBody Skieur skier){
        return skierServices.addSkier(skier);
    }
    @PutMapping("/update")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return skierServices.updateSkier(skieur);
    }
    @GetMapping("/get/{numSkier}")
    public Skieur getSkier(@PathVariable Long numSkier){
            return skierServices.retriveSkier(numSkier);
    }
    @GetMapping("/all")
    public List<Skieur> getAllSkieurs() {
        return skierServices.retriveAll();
    }

    @DeleteMapping("/delete/{numSkier}")
    public void deleteSkieur(@PathVariable Long numSkier) {
        skierServices.remouveSkier(numSkier);
    }
    @GetMapping("/getByBirthDate/{birthDate}")
    public List<Skieur> getByBirthDate(@PathVariable LocalDate birthDate){
        return skierServices.findByBirthDate(birthDate);
    }
    @PostMapping("/assign/{name}/{color}")
    public Skieur assignSkierToPiste(@PathVariable String name, @PathVariable Color color) {
        Skieur assignedSkier = skierServices.assignSkierToPiste(name, color);
        return assignedSkier;
    }
    @PostMapping("/addAndAssign/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skier,
                                           @PathVariable("numCourse") Long numCourse){
        return  skierServices.addSkierAndAssignToCourse(skier,numCourse);
    }
    @GetMapping("/getSkiersBySubscription/{type}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable("type") TypeSubscription typeSubscription) {
        return skierServices.retrieveSkiersBySubscriptionType(typeSubscription);
    }
}

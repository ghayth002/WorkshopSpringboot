package tn.esprit.charekyosr4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.entities.Piste;
import tn.esprit.charekyosr4twin5.Services.PisteServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/piste")
public class PisteRestController {

    private final PisteServiceImpl pisteService;

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @GetMapping("/get/{numPiste}")
    public Piste getPiste(@PathVariable Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteService.getAllPistes();
    }

    @DeleteMapping("/delete/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
        pisteService.removePiste(numPiste);
    }
    @PostMapping("/assign/{numSkier}/{numPiste}")
    public ResponseEntity<String> assignSkierToPiste(
            @PathVariable Long numSkier,
            @PathVariable Long numPiste) {
        pisteService.assignSkierToPiste(numSkier, numPiste);
        return ResponseEntity.ok("Le skieur a été assigné à la piste avec succès.");
    }
}

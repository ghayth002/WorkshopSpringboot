package tn.esprit.charekyosr4twin5.Services;

import tn.esprit.charekyosr4twin5.entities.Color;
import tn.esprit.charekyosr4twin5.entities.Piste;
import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    void removePiste(Long numPiste);
    Piste retrievePiste(Long numPiste);
    List<Piste> getAllPistes();
    List<Piste> getPistesByColor(Color color);
    void assignSkierToPiste(Long numSkier, Long numPiste);
}

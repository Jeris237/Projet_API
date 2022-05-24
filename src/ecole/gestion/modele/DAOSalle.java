package ecole.gestion.modele;

import ecole.metier.Classe;
import ecole.metier.Enseignant;
import ecole.metier.Infos;
import ecole.metier.Salle;

public interface DAOSalle extends DAO<Salle>{
    boolean addEnseignant(Salle sal, Enseignant ens);
    boolean suppEnseignant(Salle sal, Enseignant ens);
}

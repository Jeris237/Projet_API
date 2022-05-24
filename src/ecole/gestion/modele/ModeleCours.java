package ecole.gestion.modele;

import ecole.metier.Classe;
import ecole.metier.Cours;
import ecole.metier.Infos;

import java.util.ArrayList;
import java.util.List;

public class ModeleCours implements DAOCours{

    private List<Cours> lCours = new ArrayList<>();

    @Override
    public Cours create(Cours newObj) {
        if (lCours.contains(newObj)) return null;
        else {
            lCours.add(newObj);
            return newObj;
        }
    }

    @Override
    public Cours read(Cours objRech) {
        int indice = lCours.indexOf(objRech);
        if (indice<0) return null;
        else {
           return lCours.get(indice);
        }
    }

    @Override
    public Cours update(Cours objRech) {
        Cours cours = read(objRech);
        if(cours == null){
            return null;
        }
        else {
            cours.setIntitule(objRech.getIntitule());
            return cours;
        }
    }

    @Override
    public boolean delete(Cours objRech) {
        Cours cours = read(objRech);
        if (cours == null) return false;
        else {
            lCours.remove(cours);
            return true;
        }
    }

    @Override
    public List<Cours> readAll() {
        return lCours;
    }


}

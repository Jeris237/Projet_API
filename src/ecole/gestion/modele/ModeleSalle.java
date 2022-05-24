package ecole.gestion.modele;

import ecole.metier.Enseignant;
import ecole.metier.Infos;
import ecole.metier.Salle;

import java.util.ArrayList;
import java.util.List;

public class ModeleSalle implements DAOSalle{

    private List<Salle> lSalle = new ArrayList<>();

    @Override
    public Salle create(Salle newObj) {
        if (lSalle.contains(newObj)) return null;
        else {
            lSalle.add(newObj);
            return newObj;
        }
    }

    @Override
    public Salle read(Salle objRech) {
        int indice = lSalle.indexOf(objRech);
        if (indice<0) return null;
        else {
            return lSalle.get(indice);
        }
    }

    @Override
    public Salle update(Salle objRech) {
        Salle sal = read(objRech);
        if(sal == null){
            return null;
        }
        else {
            sal.setCapacite(objRech.getCapacite());
            return sal;
        }
    }

    @Override
    public boolean delete(Salle objRech) {
        Salle sal = read(objRech);
        if (sal == null) return false;
        else {
            lSalle.remove(sal);
            return true;
        }
    }

    @Override
    public List<Salle> readAll() {
        return lSalle;
    }

    @Override
    public boolean addEnseignant(Salle sal, Enseignant ens) {
        return sal.addEnseignant(ens);
    }

    @Override
    public boolean suppEnseignant(Salle sal, Enseignant ens) {
        return sal.suppEnseignant(ens);
    }
}

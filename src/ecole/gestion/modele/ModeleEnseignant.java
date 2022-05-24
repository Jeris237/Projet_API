package ecole.gestion.modele;

import ecole.metier.Cours;
import ecole.metier.Enseignant;
import ecole.metier.Infos;

import java.util.ArrayList;
import java.util.List;

public class ModeleEnseignant implements DAOEnseignant{

    private List<Enseignant> lEnseignant = new ArrayList<>();

    @Override
    public Enseignant create(Enseignant newObj) {
        if (lEnseignant.contains(newObj)) return null;
        else {
            lEnseignant.add(newObj);
            return newObj;
        }
    }

    @Override
    public Enseignant read(Enseignant objRech) {
        int indice = lEnseignant.indexOf(objRech);
        if (indice<0) return null;
        else {
            return lEnseignant.get(indice);
        }
    }

    @Override
    public Enseignant update(Enseignant objRech) {
        Enseignant ens = read(objRech);
        if(ens == null){
            return null;
        }
        else {
            ens.setChargeSem(objRech.getChargeSem());
            ens.setSalaireMensu(objRech.getSalaireMensu());
            ens.setDateEngag(objRech.getDateEngag());
            return ens;
        }
    }

    @Override
    public boolean delete(Enseignant objRech) {
        Enseignant ens = read(objRech);
        if (ens == null) return false;
        else {
            lEnseignant.remove(ens);
            return true;
        }
    }

    @Override
    public List<Enseignant> readAll() {
        return lEnseignant;
    }

}

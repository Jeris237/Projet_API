package ecole.gestion.modele;

import ecole.metier.Classe;
import ecole.metier.Infos;

import java.util.ArrayList;
import java.util.List;

public class ModeleClasse implements DAOClasse{

    private List<Classe> lClasse=new ArrayList<>();

    @Override
    public Classe create(Classe newObj) {
        if(lClasse.contains(newObj)) return null;
        else {
            lClasse.add(newObj);
            return newObj;
        }
    }

    @Override
    public Classe read(Classe objRech) {
        int indice = lClasse.indexOf(objRech);
        if (indice<0) return null;
        else {
            return lClasse.get(indice);
        }
    }

    @Override
    public Classe update(Classe objRech) {
        Classe classe = read(objRech);
        if (classe == null) return null;
        else {
            classe.setAnnee(objRech.getAnnee());
            classe.setNbreEleves(objRech.getNbreEleves());
            classe.setSpecialite(objRech.getSpecialite());
            return classe;
        }
    }

    @Override
    public boolean delete(Classe objRech) {
        Classe classe = read(objRech);
        if (classe == null) return false;
        else {
            lClasse.remove(objRech);
            return true;
        }
    }

    @Override
    public List<Classe> readAll() {
        return lClasse;
    }

    @Override
    public boolean addInfos(Classe cl, Infos inf) {
        return cl.addInfos(inf);
    }

    @Override
    public boolean suppInfos(Classe cl, Infos inf) {
        return cl.suppInfos(inf);
    }
}

package ecole.gestion.modele;

import ecole.metier.Classe;
import ecole.metier.Infos;

public interface DAOClasse extends DAO<Classe>{

    boolean addInfos(Classe cl, Infos inf);
    boolean suppInfos(Classe cl,Infos inf);

}

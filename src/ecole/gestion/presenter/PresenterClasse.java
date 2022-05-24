package ecole.gestion.presenter;

import ecole.gestion.modele.DAOClasse;
import ecole.gestion.vue.VueClasseInterface;
import ecole.metier.Classe;

public class PresenterClasse {

    DAOClasse mdcl;
    VueClasseInterface vuecl;

    public PresenterClasse(DAOClasse mcdl, VueClasseInterface vuecl) {
        this.mdcl = mdcl;
        this.vuecl = vuecl;
    }

    public void gestion(){

        do {
            int ch = vuecl.menu(new String[]{"ajout","recherche", "modification",
                    "suppression","affichage complet","ajout infos","suppression infos","fin"});
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                    affAll();
                    break;
                case 6:addInfos();
                    break;
                case 7:suppInfos();
                    break;
                case 8 :  return;
            }
        } while (true);
    }


    protected void ajout() {

    }

}

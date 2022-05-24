package ecole.gestion.vue;

import ecole.metier.Classe;
import ecole.metier.Cours;

import java.util.List;

public class VueCours extends VueCommune implements VueCoursInterface {
    @Override
    public Cours create() {
        String code = getMsg("Code du Cours : ");
        String intitule = getMsg("Intitulé du Cours : ");
        Cours cours = new Cours(code,intitule);
        return cours;
    }

    @Override
    public String read() {
        String code = getMsg("Code du cours : ");
        return code;
    }

    @Override
    public Cours update(Cours crs) {
        do {
            String chaine = getMsg("1.Changer le code du cours\n2.changer l'intitulé du cours\n3.fin");
            switch (chaine) {
                case "1":
                    String nCode = getMsg("nouveau code : ");
                    crs.setCode(nCode);
                    break;
                case "2":
                    String nIntitule = getMsg("nouveau intitulé : ");
                    crs.setIntitule(nIntitule);
                    break;
                case "3":
                    return crs;
                default:
                    displayMsg("choix invalide");
            }

        } while (true);
    }

    @Override
    public void display(Cours crs) {
        displayMsg(crs.toString());
    }

    @Override
    public void affAll(List<Cours> lcrs) {
        int i =0;
        for(Cours crs:lcrs){
            displayMsg((++i)+"."+crs.toString());
        }
    }
}

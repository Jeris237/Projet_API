package ecole.gestion.vue;


import ecole.metier.Classe;

import java.util.List;

public class VueClasse extends VueCommune implements VueClasseInterface{

    @Override
    public Classe create() {
        String sigle = getMsg("Sigle :");
        Integer annee = Integer.parseInt(getMsg("Année : "));
        String specialite= getMsg("Spécialité : ");
        Integer nbrElev = Integer.parseInt(getMsg("Nombre d'élèves : "));
        Classe classe = new Classe(sigle,annee,specialite,nbrElev);
        return classe;
    }

    @Override
    public String read() {
        String sigle = getMsg("Sigle de la classe : ");
        return sigle;
    }

    @Override
    public Classe update(Classe cl) {
        do {
            String chaine = getMsg("1.changer l'année\n2.changer de specialité\n3.changer le nombre d'élèves\n4.fin");
            switch (chaine) {
                case "1":
                    int nAnnee = Integer.parseInt(getMsg("nouvelle année : "));
                    cl.setAnnee(nAnnee);
                    break;
                case "2":
                    String nSpecialite = getMsg("nouvelle specialité : ");
                    cl.setSpecialite(nSpecialite);
                    break;
                case "3":
                    int nNbreElev = Integer.parseInt(getMsg("nouveau nombre d'élèves :"));
                    cl.setNbreEleves(nNbreElev);
                    break;
                case "4":
                    return cl;
                default:
                    displayMsg("choix invalide");
            }

        } while (true);

    }

    @Override
    public void display(Classe cl) {
        displayMsg(cl.toString());
    }

    @Override
    public void affAll(List<Classe> lcl) {
        int i =0;
        for(Classe cl:lcl){
            displayMsg((++i)+"."+cl.toString());
        }
    }


}

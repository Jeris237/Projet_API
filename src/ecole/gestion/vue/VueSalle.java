package ecole.gestion.vue;

import ecole.metier.Enseignant;
import ecole.metier.Salle;

import java.util.List;

public class VueSalle extends VueCommune implements VueSalleInterface{

    @Override
    public Salle create() {
        String sigle = getMsg("Sigle : ");
        int capacite = Integer.parseInt(getMsg("Capacité : "));
        Salle salle = new Salle(sigle,capacite);
        return salle;
    }

    @Override
    public String read() {
        String sigle = getMsg("Sigle de la salle : ");
        return sigle;
    }

    @Override
    public Salle update(Salle salle) {
        do {
            String chaine = getMsg("1.changer le sigle\n2.changer la capacité\n3.fin");
            switch (chaine) {
                case "1":
                    String nSigle = getMsg("nouveau sigle : ");
                    salle.setSigle(nSigle);
                    break;
                case "2":
                    int nCapacite = Integer.parseInt(getMsg("nouvelle capacité : "));
                    salle.setCapacite(nCapacite);
                    break;
                case "3":
                    return salle;
                default:
                    displayMsg("choix invalide");
            }

        } while (true);
    }

    @Override
    public void display(Salle salle) {
        displayMsg(salle.toString());
    }

    @Override
    public void affAll(List<Salle> lsalle) {
        int i =0;
        for(Salle salle : lsalle){
            displayMsg((++i)+"."+lsalle.toString());
        }
    }
}

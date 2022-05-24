package ecole.gestion.vue;

import ecole.metier.Cours;
import ecole.metier.Enseignant;

import java.time.LocalDate;
import java.util.List;

public class VueEnseignant extends VueCommune implements VueEnseignantInterface{

    @Override
    public Enseignant create() {
        String matricule = getMsg("Metricule : ");
        String nom = getMsg("Nom : ");
        String prenom = getMsg("Prenom : ");
        String tel = getMsg("Numéro de telephone : ");
        int chSem = Integer.parseInt(getMsg("Charge Semestrielle : "));
        double salMens = Double.parseDouble(getMsg("Salaire Mensuel : "));
        LocalDate dateEng = LocalDate.parse(getMsg("Date d'engagement : "));
        Enseignant enseignant = new Enseignant(matricule,nom,prenom,tel,chSem,salMens,dateEng);
        return enseignant;
    }

    @Override
    public String read() {
        String matricule = getMsg("Matricule de l'enseignant : ");
        return matricule;
    }

    @Override
    public Enseignant update(Enseignant enseignant) {
        do {
            String chaine = getMsg("1.Changer la charge semestrielle\n" +
                                         "2.Changer salaire mensuel\n" +
                                         "\n3.Changer la date d'engagement\n4.fin");
            switch (chaine) {
                case "1":
                    int nChSem = Integer.parseInt(getMsg("nouvelle charge semestrielle : "));
                    enseignant.setChargeSem(nChSem);
                    break;
                case "2":
                    double nSalMens = Double.parseDouble(getMsg("nouveau salaire mensuel : "));
                    enseignant.setSalaireMensu(nSalMens);
                    break;
                case "3":
                    LocalDate nDateEngag = LocalDate.parse(getMsg("nouveau salaire mensuel : "));
                    enseignant.setDateEngag(nDateEngag);
                    break;
                case "4":
                    return enseignant;
                default:
                    displayMsg("choix invalide");
            }

        } while (true);
    }

    @Override
    public void display(Enseignant ens) {
        displayMsg(ens.toString());
    }

    @Override
    public void affAll(List<Enseignant> lens) {
        int i =0;
        for(Enseignant ens:lens){
            displayMsg((++i)+"."+ens.toString());
        }
    }
}

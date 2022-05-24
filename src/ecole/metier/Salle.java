package ecole.metier;

import java.util.ArrayList;
import java.util.List;

public class Salle {

    private static int idSalleAct=0;
    private int idSalle;
    private String sigle;
    private int capacite;
    private List<Enseignant> listEnseignant=new ArrayList<>();

    public Salle(String sigle, int capacite) {
        this.sigle = sigle;
        this.capacite = capacite;
        this.idSalle=++idSalleAct;
    }

    public Salle(String sigle, int capacite, List<Enseignant> listEnseignant) {
        this.sigle = sigle;
        this.capacite = capacite;
        this.listEnseignant = listEnseignant;
        this.idSalle=++idSalleAct;
    }

    public Salle(int idSalle,String sigle, int capacite) {
        this.sigle = sigle;
        this.capacite = capacite;
        this.idSalle=idSalle;
    }

    public Salle(int idSalle,String sigle, int capacite, List<Enseignant> listEnseignant) {
        this.sigle = sigle;
        this.capacite = capacite;
        this.listEnseignant = listEnseignant;
        this.idSalle=idSalle;
    }

    public boolean addEnseignant(Enseignant ens){
        if (listEnseignant.contains(ens)){
            return false;
        }
        else {
            listEnseignant.add(ens);
            return true;
        }
    }

    public boolean suppEnseignant(Enseignant ens){
        if (listEnseignant.contains(ens)){
            return false;
        }
        else {
            listEnseignant.remove(ens);
            return true;
        }
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Enseignant> getListEnseignant() {
        return listEnseignant;
    }

    public void setListEnseignant(List<Enseignant> listEnseignant) {
        this.listEnseignant = listEnseignant;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "sigle='" + sigle + '\'' +
                ", capacite=" + capacite +
                ", listEnseignant=" + listEnseignant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salle)) return false;
        Salle salle = (Salle) o;
        return sigle.equals(salle.sigle);
    }


}

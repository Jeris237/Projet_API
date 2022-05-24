package ecole.metier;

import java.util.Objects;

public class Infos {

    private int nbreHeures;
    private Cours cours;
    private Enseignant enseignant;
    private Salle salle;

    public Infos() {

    }

    public Infos(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public Infos(int nbreHeures, Cours cours, Enseignant enseignant, Salle salle) {
        this.nbreHeures = nbreHeures;
        this.cours = cours;
        this.enseignant = enseignant;
        this.salle = salle;
    }

    public Infos(Cours cours,int nbreHeures) {
        this.nbreHeures = nbreHeures;
        this.cours = cours;
    }

    public Infos(Salle salle,int nbreHeures) {
        this.nbreHeures = nbreHeures;
        this.salle = salle;
    }

    public Infos(Enseignant enseignant, int nbreHeures) {
        this.nbreHeures = nbreHeures;
        this.enseignant = enseignant;
    }

    public Infos(Cours cours){
        this.cours=cours;
    }

    public Infos(Cours cours, Enseignant enseignant) {
        this.cours = cours;
        this.enseignant = enseignant;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Infos{" +
                "nbreHeures=" + nbreHeures +
                ", cours=" + cours +
                ", enseignant=" + enseignant +
                ", salle=" + salle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Infos)) return false;
        Infos infos = (Infos) o;
        return cours.equals(infos.cours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cours);
    }
}

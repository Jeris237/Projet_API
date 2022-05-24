package ecole.metier;

import java.time.LocalDate;

public class Enseignant {

    private static int idEnseignantAct = 0;
    private int idEnseignant;
    private String matricule;
    private String nom;
    private String prenom;
    private String tel;
    private int chargeSem;
    private Double salaireMensu;
    private LocalDate dateEngag;
    private Salle salle;

    public Enseignant() {

    }

    public Enseignant(String matricule, String nom, String prenom, String tel, int chargeSem, Double salaireMensu, LocalDate dateEngag) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
        this.idEnseignant=++idEnseignantAct;
    }

    public Enseignant(String matricule, String nom, String prenom, String tel, int chargeSem, Double salaireMensu, LocalDate dateEngag, Salle salle) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
        this.salle = salle;
        this.idEnseignant=++idEnseignantAct;
    }

    public Enseignant(int idEnseignant,String matricule, String nom, String prenom, String tel, int chargeSem, Double salaireMensu, LocalDate dateEngag) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
        this.idEnseignant=idEnseignant;
    }

    public Enseignant(int idEnseignant,String matricule, String nom, String prenom, String tel, int chargeSem, Double salaireMensu, LocalDate dateEngag, Salle salle) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
        this.salle = salle;
        this.idEnseignant=idEnseignant;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getChargeSem() {
        return chargeSem;
    }

    public void setChargeSem(int chargeSem) {
        this.chargeSem = chargeSem;
    }

    public Double getSalaireMensu() {
        return salaireMensu;
    }

    public void setSalaireMensu(Double salaireMensu) {
        this.salaireMensu = salaireMensu;
    }

    public LocalDate getDateEngag() {
        return dateEngag;
    }

    public void setDateEngag(LocalDate dateEngag) {
        this.dateEngag = dateEngag;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", chargeSem=" + chargeSem +
                ", salaireMensu=" + salaireMensu +
                ", dateEngag=" + dateEngag +
                ", salle=" + salle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enseignant)) return false;
        Enseignant that = (Enseignant) o;
        return matricule.equals(that.matricule);
    }

}

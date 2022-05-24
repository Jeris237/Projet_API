package ecole.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Classe {

    private static int idClasseAct=0;
    private int idClasse;
    private String sigle;
    private int annee;
    private String specialite;
    private int nbreEleves;
    private List<Infos> listeInfos = new ArrayList<>();

    public Classe() {

    }

    public Classe(int idClasse,String sigle, int annee, String specialite, int nbreEleves) {
        this.idClasse=idClasse;
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
    }

    public Classe(String sigle, int annee, String specialite, int nbreEleves) {
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
        this.idClasse=++idClasseAct;
    }

    public Classe(int idClasse,String sigle, int annee, String specialite, int nbreEleves, List<Infos> listeInfos) {
        this.idClasse=idClasse;
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
        this.listeInfos = listeInfos;
    }

    public Classe(String sigle, int annee, String specialite, int nbreEleves, List<Infos> listeInfos) {
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
        this.listeInfos = listeInfos;
        this.idClasse=++idClasseAct;
    }

    public int nbreHeuresTot(){
        int heureTot=0;
        for(Infos inf : listeInfos){
            heureTot+=inf.getNbreHeures();
        }
        return heureTot;
    }

    public List<Infos> listeEnseignantsEtHeures(){
        List<Infos> lEnseignantsETHeures = new ArrayList<>();
        if(listeInfos.isEmpty()){
            return null;
        }

        for(Infos infos : listeInfos){
            lEnseignantsETHeures.add(new Infos(infos.getEnseignant(),infos.getNbreHeures()));
        }
        return lEnseignantsETHeures;
    }

    public List<Infos> listeSallesetHeures(){
        List<Infos> lSalleEtHeures = new ArrayList<>();
        if(listeInfos.isEmpty()){
            return null;
        }
        for(Infos infos : listeInfos){
            lSalleEtHeures.add(new Infos(infos.getSalle(),infos.getNbreHeures()));
        }
        return lSalleEtHeures;
    }

    public List<Infos> listeCoursEtHeures(){
        List<Infos> lCoursEtHeures = new ArrayList<>();
        if(listeInfos.isEmpty()){
            return null;
        }
        for(Infos infos : listeInfos){
            lCoursEtHeures.add(new Infos(infos.getCours(),infos.getNbreHeures()));
        }
        return lCoursEtHeures;
    }

    public boolean salleCapaciteOK(Salle salle){
        if(salle.getCapacite()<=0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean addCours(Cours cours,int heures){
        boolean ok=listeInfos.contains(new Infos(cours));

        if (!ok){
            return false;
        }
        else {
            listeInfos.add(new Infos(cours,heures));

            return true;
        }

    }

    public boolean modifCours(Cours cours,Enseignant ens){
        int coursRech=listeInfos.indexOf(new Infos(cours));

        if(coursRech<0){
            return false;
        }
        else {
            listeInfos.get(coursRech).setEnseignant(ens);
            return true;
        }
    }

    public boolean modifCours(Cours cours,Salle salle){
        int coursRech = listeInfos.indexOf(new Infos(cours));
        if(coursRech<0){
            return false;
        }
        else {
            listeInfos.get(coursRech).setSalle(salle);
            return true;
        }
    }

    public boolean modifCours(Cours cours,int heures){

        int coursRech = listeInfos.indexOf(new Infos(cours));
        if(coursRech<0){
            return false;
        }
        else {
            listeInfos.get(coursRech).setNbreHeures(heures);
            return true;
        }
    }

    public boolean suppCours(Cours cours){
        int coursRech = listeInfos.indexOf(new Infos(cours));

        if(coursRech<0){
            return false;
        }
        else {
            listeInfos.remove(listeInfos.get(coursRech));
            return true;
        }

    }


    public boolean addInfos(Infos inf){
        if (listeInfos.contains(inf)){
            return false;
        }
        listeInfos.add(inf);
        return true;
    }

    public boolean suppInfos(Infos inf){
        if (!listeInfos.contains(inf)){
            return false;
        }
        else {
            listeInfos.remove(inf);
            return true;
        }
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getNbreEleves() {
        return nbreEleves;
    }

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    public List<Infos> getListeInfos() {
        return listeInfos;
    }

    public void setListeInfos(List<Infos> listeInfos) {
        this.listeInfos = listeInfos;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "sigle='" + sigle + '\'' +
                ", annee=" + annee +
                ", specialite='" + specialite + '\'' +
                ", nbreEleves=" + nbreEleves +
                ", listeInfos=" + listeInfos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classe)) return false;
        Classe classe = (Classe) o;
        return getSigle().equals(classe.getSigle());
    }

}

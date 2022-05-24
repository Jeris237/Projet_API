package ecole.metier;

public class Cours {

    private static int idCoursAct=0;
    private  int idCours;
    private String code;
    private String intitule;

    public Cours() {

    }

    public Cours(int idCours,String code, String intitule) {
        this.idCours=idCours;
        this.code = code;
        this.intitule = intitule;
    }

    public Cours(String code, String intitule) {
        this.idCours=idCours;
        this.code = code;
        this.intitule = intitule;
        this.idCours=++idCoursAct;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "code='" + code + '\'' +
                ", intitule='" + intitule + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cours)) return false;
        Cours cours = (Cours) o;
        return code.equals(cours.code);

    }


}

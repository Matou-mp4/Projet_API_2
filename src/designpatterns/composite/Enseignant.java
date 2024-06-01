package designpatterns.composite;

import Ecole.Classe;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Enseignant {
    /**
     * matricule unique, nom, prenom et numéro de téléphone de l'enseignant
     */
    protected String matricule, nom, prenom,tel;
    /**
     *  charge de la semaine de l'enseignant
     */
    protected int chargeSem;
    /**
     * Salaire mensuel de l'ensegnant
     */
    protected BigDecimal salaireMensu;
    /**
     * Date d'engagement de l'ensegnant
     */
    protected LocalDate dateEngag;
    /**
     * Class.Classe préférée de l'enseignant
     */
    protected Classe preference;

    public Enseignant() {
    }

    public Enseignant(String matricule, String nom, String prenom, String tel, int chargeSem, BigDecimal salaireMensu, LocalDate dateEngag, Classe preference) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
        this.preference = preference;
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

    public BigDecimal getSalaireMensu() {
        return salaireMensu;
    }

    public void setSalaireMensu(BigDecimal salaireMensu) {
        this.salaireMensu = salaireMensu;
    }

    public LocalDate getDateEngag() {
        return dateEngag;
    }

    public void setDateEngag(LocalDate dateEngag) {
        this.dateEngag = dateEngag;
    }

    public Ecole.Classe getPreference() {
        return preference;
    }

    public void setPreference(Classe preference) {
        this.preference = preference;
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
                ", preference=" + preference +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant that = (Enseignant) o;
        return Objects.equals(matricule, that.matricule) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(tel, that.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule, nom, prenom, tel);
    }
}

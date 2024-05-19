package designpatterns.composite;

import designpatterns.builder.Infos;

import java.util.ArrayList;
import java.util.Objects;

public class Classe {
    /**
     * le sigle et la specialité unique de la classe
     */
    protected String sigle, specialite;
    /**
     * l'id, l'annee et le nombre de l'élève de la classe
     */
    protected int idClasse, annee, nbreEleves;
    /**
     * Liste d'informations de la classe
     * Chaque infos contient :
     * - l'enseignant
     * - le cours
     * - la salle
     * - le nombre d'heures
     */
    protected ArrayList<Infos> listeInfos = new ArrayList<>();

    public Classe() {
    }

    public Classe(String sigle, String specialite, int idClasse, int annee, int nbreEleves) {
        this.sigle = sigle;
        this.specialite = specialite;
        this.idClasse = idClasse;
        this.annee = annee;
        this.nbreEleves = nbreEleves;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbreEleves() {
        return nbreEleves;
    }

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    public ArrayList<Infos> getListeInfos() {
        return listeInfos;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "sigle='" + sigle + '\'' +
                ", specialite='" + specialite + '\'' +
                ", idClasse=" + idClasse +
                ", annee=" + annee +
                ", nbreEleves=" + nbreEleves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return idClasse == classe.getIdClasse();
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClasse);
    }
}

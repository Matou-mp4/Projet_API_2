package designpatterns.observer;

import Ecole.Cours;
import Ecole.Enseignant;
import Ecole.Salle;

import java.util.Objects;

public class Infos {
    /**
     * nombre d'heure d'un cours donné
     */
    protected int nbreHeures;
    /**
     * cours donné
     */
    protected Cours cours;
    /**
     * enseignant donnant le cours
     */
    protected Enseignant enseignant;
    /**
     * sallee où le cours est donné
     */
    protected Salle salle;

    public Infos() {
    }

    public Infos(int nbreHeures, Cours cours, Enseignant enseignant, Salle salle) {
        this.nbreHeures = nbreHeures;
        this.cours = cours;
        this.enseignant = enseignant;
        this.salle = salle;
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
        if (o == null || getClass() != o.getClass()) return false;
        Infos infos = (Infos) o;
        return nbreHeures == infos.nbreHeures && Objects.equals(cours, infos.cours) && Objects.equals(enseignant, infos.enseignant) && Objects.equals(salle, infos.salle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbreHeures, cours, enseignant, salle);
    }
}

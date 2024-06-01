package designpatterns.composite;

import Ecole.Enseignant;

import java.util.ArrayList;
import java.util.Objects;

public class Salle {
    /**
     * sigle unique de la salle
     */
    protected String sigle;
    /**
     * capacité de la classe
     */
    protected int capacite;
    /**
     * liste d'enseignant attitrés à cette salle
     */
    protected ArrayList<Enseignant> listeEnseignant=new ArrayList<>();

    public Salle() {
    }

    public Salle(String sigle, int capacite) {
        this.sigle = sigle;
        this.capacite = capacite;
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

    public ArrayList<Enseignant> getListeEnseignant() {
        return listeEnseignant;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "sigle='" + sigle + '\'' +
                ", capacite=" + capacite +
                ", listeEnseignant=" + listeEnseignant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return capacite == salle.capacite && Objects.equals(sigle, salle.sigle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigle, capacite);
    }
}

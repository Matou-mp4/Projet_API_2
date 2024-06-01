package Ecole;

import java.util.ArrayList;
import java.util.Objects;
/** Class.Classe Class.Salle
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class Salle {
    /**
     * sigle unique de la salle
     */
    protected int sigle;
    /**
     * capacité de la classe
     */
    protected int capacite;
    /**
     * liste d'enseignant attitrés à cette salle
     */
    protected ArrayList<Enseignant> listeEnseignant=new ArrayList<>();

    /**
     * Constructeur paramétrè de la salle
     * @param sigle
     * @param capacite
     */
    public Salle(int sigle, int capacite) {
        this.sigle = sigle;
        this.capacite = capacite;
    }

    public Salle(int sigle) {
        this.sigle=sigle;
    }

    /**
     * fonction retournant la capacité de la classe
     * @return capacite capacite de la classe
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * fonction retournant le sigle de la classe
     * @return sigle sigle de la classe
     */
    public int getSigle() {
        return sigle;
    }

    /**
     *Verification de l'égalité de deux salles
     * @param o
     * @return égalité ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return capacite == salle.capacite && Objects.equals(sigle, salle.sigle);
    }

    /**
     *  calcul du hashcode de la salle
     * @return valeur du hashcode de la salle
     */
    @Override
    public int hashCode() {
        return Objects.hash(sigle, capacite);
    }

    public void setSigle(int sigle) {
        this.sigle = sigle;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public ArrayList<Enseignant> ensSalleDefault() {
        ArrayList<Enseignant> enseignants = new ArrayList<>();
        for ( Enseignant element : listeEnseignant) {
            if (element.getPreference().getSigle()==sigle) {
                enseignants.add(element);
                break;
            }
        }
        return enseignants;
    }
}

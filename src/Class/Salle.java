package Class;

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
    protected String sigle;
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
    public Salle(String sigle, int capacite) {
        this.sigle = sigle;
        this.capacite = capacite;
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
    public String getSigle() {
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
     * calcul du hashcode de la salle
     * @return valeur du hashcode de la salle
     */
    @Override
    public int hashCode() {
        return Objects.hash(sigle, capacite);
    }
}

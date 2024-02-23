import java.util.Objects;
/** Classe Salle
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class Salle {
    protected String sigle;
    protected int capacite;
    public Salle(){

    }

    public int getCapacite() {
        return capacite;
    }

    public String getSigle() {
        return sigle;
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

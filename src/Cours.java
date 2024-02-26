import java.util.Objects;
/** Classe Cours
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class Cours {
    /**
     * Code unique et intilé du cours
     */
    protected String code,intitule;

    /**
     * Constructeur de la classe cours
     * @param code code unique
     * @param intitule intitulé
     */
    public Cours(String code, String intitule) {
        this.code = code;
        this.intitule = intitule;
    }

    /**
     *Verification de l'égalité de deux cours
     * @param o
     * @return égalité ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Objects.equals(code, cours.code) && Objects.equals(intitule, cours.intitule);
    }
    /**
     * calcul du hashcode du cours
     * @return valeur du hashcode du cours
     */
    @Override
    public int hashCode() {
        return Objects.hash(code, intitule);
    }
}

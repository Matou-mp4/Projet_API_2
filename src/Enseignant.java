import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
        /** Classe Enseignant
        * @Author Dangreau Antoine
        * @Version 1.0
        */
public class Enseignant {
    protected String matricule, nom, prenom,tel;
    protected int chargeSem;
    protected BigDecimal salaireMensu;
    protected LocalDate dateEngag;
    protected Classe preference;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant that = (Enseignant) o;
        return chargeSem == that.chargeSem && Objects.equals(matricule, that.matricule) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(tel, that.tel) && Objects.equals(salaireMensu, that.salaireMensu) && Objects.equals(dateEngag, that.dateEngag) && Objects.equals(preference, that.preference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule, nom, prenom, tel, chargeSem, salaireMensu, dateEngag, preference);
    }
}

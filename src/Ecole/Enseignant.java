package Ecole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
        /** Class.Classe Class.Enseignant
        * @Author Dangreau Antoine
        * @Version 1.0
        */
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

            /**
             * Constructeur parametré de la classe Class.Enseignant
             * @param matricule
             * @param nom
             * @param prenom
             * @param tel
             * @param chargeSem
             * @param salaireMensu
             * @param dateEngag
             * @param preference
             */
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
            /**
             *Verification de l'égalité de deux enseignants
             * @param o
             * @return égalité ou non
             */
            @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant that = (Enseignant) o;
        return chargeSem == that.chargeSem && Objects.equals(matricule, that.matricule) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(tel, that.tel) && Objects.equals(salaireMensu, that.salaireMensu) && Objects.equals(dateEngag, that.dateEngag) && Objects.equals(preference, that.preference);
    }
            /**
             * calcul du hashcode de l'enseignant
             * @return valeur du hashcode de l'enseignant
             */
    @Override
    public int hashCode() {
        return Objects.hash(matricule, nom, prenom, tel, chargeSem, salaireMensu, dateEngag, preference);
    }

            public String getNom() {
                return nom;
            }
        }

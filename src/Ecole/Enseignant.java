package Ecole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
        /** Class.Salle Class.Enseignant
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
             * Class.Salle préférée de l'enseignant
             */
    protected Salle preference;

            /**
             * Constructeur parametré de la Salle Class.Enseignant
             * @param matricule
             * @param nom
             * @param prenom
             * @param tel
             * @param chargeSem
             * @param salaireMensu
             * @param dateEngag
             * @param preference
             */
            public Enseignant(String matricule, String nom, String prenom, String tel, int chargeSem, BigDecimal salaireMensu, LocalDate dateEngag, Salle preference) {
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

            public Salle getPreference() {
                return preference;
            }

            public void setPreference(Salle preference) {
                this.preference = preference;
            }
        }

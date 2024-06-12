package designpatterns.builderExamen;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    protected Salle preference;
    protected int nbreMaxEtu;

    public Enseignant(EnseignantBuilder eb){
        this.preference=eb.preference;
        this.nom= eb.nom;
        this.chargeSem= eb.chargeSem;
        this.dateEngag=eb.dateEngag;
        this.tel= eb.tel;
        this.prenom=eb.prenom;
        this.salaireMensu=eb.salaireMensu;
        this.matricule=eb.matricule;
        this.nbreMaxEtu=eb.nbreMaxEtu;
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
    public int getNbreMaxEtu() {
        return nbreMaxEtu;
    }

    public void setNbreMaxEtu(int nbreMaxEtu) {
        this.nbreMaxEtu = nbreMaxEtu;
    }
    @Override
    public String toString() {
        return "EnseignantBuilder{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", preference=" + preference +
                ", nbreMaxEtu=" + nbreMaxEtu +
                '}';
    }

    public void setPreference(Salle preference) {
        this.preference = preference;
    }
        public static class EnseignantBuilder{
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
            protected Salle preference;
            protected int nbreMaxEtu;



            public EnseignantBuilder setMatricule(String matricule) {
                this.matricule = matricule;
                return this;
            }

            public EnseignantBuilder setNom(String nom) {
                this.nom = nom;
                return this;
            }

            public EnseignantBuilder setPrenom(String prenom) {
                this.prenom = prenom;
                return this;
            }

            public EnseignantBuilder setTel(String tel) {
                this.tel = tel;
                return this;
            }

            public EnseignantBuilder setChargeSem(int chargeSem) {
                this.chargeSem = chargeSem;
                return this;
            }

            public EnseignantBuilder setSalaireMensu(BigDecimal salaireMensu) {
                this.salaireMensu = salaireMensu;
                return this;
            }

            public EnseignantBuilder setDateEngag(LocalDate dateEngag) {
                this.dateEngag = dateEngag;
                return this;
            }

            public EnseignantBuilder setPreference(Salle preference) {
                this.preference = preference;
                return this;
            }
            public EnseignantBuilder setNbreMaxEtu(int nbreMaxEtu) {
                this.nbreMaxEtu = nbreMaxEtu;
                return this;
            }
            public Enseignant build() throws Exception{
                if(matricule==null || nom == null || prenom == null || preference==null || nbreMaxEtu<=0) throw new Exception("informations de construction incomplètes");
                return new Enseignant(this);
            }


        }
}

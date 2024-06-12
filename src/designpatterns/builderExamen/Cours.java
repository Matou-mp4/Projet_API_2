package designpatterns.builderExamen;
import java.util.Objects;
public class Cours {
    /**
     * Code unique et intilé du cours
     */
    protected String code,intitule;
    public Cours(CoursBuilder cb) {
        this.code = cb.code;
        this.intitule = cb.intitule;
    }
    public String getCode() {
        return code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIntitule(String intitule) {
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
        return Objects.equals(code, cours.getCode()) && Objects.equals(intitule, cours.getIntitule());
    }
    /** p
     * calcul du hashcode du cours
     * @return valeur du hashcode du cours
     */
    @Override
    public int hashCode() {
        return Objects.hash(code, intitule);
    }
        public static class CoursBuilder{
            protected String code,intitule;

            public CoursBuilder setCode(String code) {
                this.code = code;
                return this;
            }

            public CoursBuilder setIntitule() {
                this.intitule = intitule;
                return this;
            }

            public Cours build() throws Exception{
                if(code == null || intitule == null) throw new Exception("informations de construction incomplètes");
                return new Cours(this);
            }
        }
}


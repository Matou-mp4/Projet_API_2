import java.util.Objects;

public class Cours {
    protected String code,intitule;
    public Cours(){

    }
    public void afficheCours(){
        System.out.println(intitule+"(code : "+code+")");
    }
    /*
    * to do
    * - equals override
    * */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Objects.equals(code, cours.code) && Objects.equals(intitule, cours.intitule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, intitule);
    }
}

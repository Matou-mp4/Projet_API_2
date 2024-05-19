package designpatterns.composite;

import java.util.Objects;

public class Cours {
    /**
     * Code unique et intilé du cours
     */
    protected String code,intitule;

    public Cours() {
    }

    public Cours(String code, String intitule) {
        this.code = code;
        this.intitule = intitule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "code='" + code + '\'' +
                ", intitule='" + intitule + '\'' +
                '}';
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Objects.equals(code, cours.getCode()) && Objects.equals(intitule, cours.getIntitule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, intitule);
    }
}

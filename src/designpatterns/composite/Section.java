package designpatterns.composite;

import java.util.HashSet;
import java.util.Set;

public class Section  extends Element{
    private String nom;
    private Set<Element> elts=new HashSet<>();

    public Section(int id, String nom) {
        super(id);
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Section{" +
                "nom='" + nom + '\'' +
                ", elts=" + elts +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public Set<Element> getElts() {
        return elts;
    }

}

package designpatterns.composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Section  extends Element{
    private String nom;
    private Set<Element> elts=new HashSet<>();
    private ArrayList<Classe> classes = new ArrayList<>();

    private Element section = null;

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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setElts(Set<Element> elts) {
        this.elts = elts;
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }

    public Element getSection() {
        return section;
    }

    public void setSection(Element section) {
        this.section = section;
    }

    @Override
    public int nbreEleves() {
        int nbreEleves=0;
        for (Classe element: classes
             ) {
            nbreEleves = element.nbreEleves + nbreEleves;
        }
        return nbreEleves;
    }

}

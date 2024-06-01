package designpatterns.composite;

public class Ecole {
    public static void main(String[] args) {
        Classe cl1 = new Classe("A","Math",1,1,20);
        Classe cl2 = new Classe("B","Francais",2,1,20);
        Classe cl3 = new Classe("A","Math",3,2,20);
        Classe cl4 = new Classe("C","Science",4,2,20);
        Section s1 = new Section(1, "Scientifique");
        Section s2 = new Section(2, "Langue");
        Section s3 = new Section(3, "Math");
        s1.getElts().add(s3);
        s3.getClasses().add(cl1);
        s3.getClasses().add(cl3);
        s2.getClasses().add(cl2);
        s1.getClasses().add(cl4);
        System.out.println(s1);
        System.out.println("nombre d'eleves : "+s1.nbreEleves());
    }
}

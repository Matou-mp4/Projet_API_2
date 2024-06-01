package designpatterns.builder;

public class Ecole {
    public static void main(String[] args)  {

        try {
            Classe cl1 = new Classe.ClasseBuilder().
                    setIdClasse(1).
                    setAnnee(1).
                    setSigle("A").
                    setNbreEleves(21).
                    setSpecialite("Math").
                    build();
            System.out.println(cl1);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }

        try {
            Classe cl2 = new Classe.ClasseBuilder().
                    setIdClasse(2).
                    setAnnee(1).
                    setSigle("B").
                    setNbreEleves(19).
                    setSpecialite("Francais").
                    build();
            System.out.println(cl2);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }

    }
}

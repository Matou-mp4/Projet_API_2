package designpatterns.builderExamen;

public class Ecole {
    public static void main(String[] args)  {
        Salle salle;
        try {
            salle = new Salle.SalleBuilder().setSigle(1).setCapacite(23).builder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Enseignant e1 = new Enseignant.EnseignantBuilder().
                    setMatricule("JMI").setNom("Jean").setPreference(salle).setPrenom("Michel").build();
            System.out.println(e1);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }

        try {
            Enseignant e2 = new Enseignant.EnseignantBuilder().
                    setMatricule("JMI").setNom("Jean").setPreference(salle).setPrenom("Michel").setNbreMaxEtu(25).build();
            System.out.println(e2);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }

    }
}

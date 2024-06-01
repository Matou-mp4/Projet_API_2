package designpatterns.observer;

import designpatterns.observer.*;


public class Ecole {
    public static void main(String[] args) {
        Classe cl1 = new Classe("A","Math",1,1,20);
        Classe cl2 = new Classe("B","Francais",2,1,20);
        Enseignant e1 = new Enseignant("JMI","Michel","Jhon","0475121212",20);
        Enseignant e2 = new Enseignant("LDE","Delattre","Laurent","0475101010",20);
        cl1.addObserver(e1);
        cl1.addObserver(e2);
        cl1.addObserver(e1);

        cl1.setNbreEleves(21);
        cl2.setNbreEleves(19);
    }
}

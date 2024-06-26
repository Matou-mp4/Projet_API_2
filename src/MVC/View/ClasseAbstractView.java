package MVC.View;
import MVC.observer.Observer;
import MVC.controller.ClasseController;
import Ecole.Classe;

import java.util.ArrayList;
import java.util.List;

public abstract class ClasseAbstractView implements Observer {
    protected ClasseController classeController;
    protected List<Classe> lc;

    public void setController(ClasseController classeController){
        this.classeController=classeController;
    }

    public abstract void affMsg(String msg);

    public abstract Classe selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}

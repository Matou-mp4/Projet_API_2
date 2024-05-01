package MVC.View;
import MVC.observer.Observer;
import MVC.controller.CoursController;
import Ecole.Cours;
import java.util.List;

public abstract class CoursAbstractView implements Observer {
    protected CoursController CoursController;
    protected List<Cours> lc;

    public void setController(CoursController CoursController){
        this.CoursController=CoursController;
    }

    public abstract void affMsg(String msg);

    public abstract Cours selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}

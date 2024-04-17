package Model.Domain.mapRoute;
import Model.Domain.Train;
import dataStructures.ArrayList;
import dataStructures.Interfaces.List;
import dataStructures.Queue;

public class Route {

    ArrayList<Rail> rails;
    Train train;
    public Route(Rail[] rails, Train train){
        this.rails = new ArrayList<>(rails);
        this.train = train;
    }

    public Rail[] getRails() {
        return rails.toArray();
    }

    public Boolean containRail(Rail rail){
        return rails.contains(rail);
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}

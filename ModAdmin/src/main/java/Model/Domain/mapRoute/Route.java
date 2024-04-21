package Model.Domain.mapRoute;

import Model.Domain.Train;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;

public class Route {
    String departureTime;

    String arrivalTime;
    ArrayList<Rail> rails;
    Train train;

    int totalDistance;

    public Route(Rail[] rails, Train train) {
        this.rails = new ArrayList<>(rails);
        this.train = train;
    }

    public Rail[] getRails() {
        return rails.toArray(new Rail[]{});
    }

    public Boolean containRail(Rail rail) {
        return rails.contains(rail);
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setTime(String time) {
        this.departureTime = time;
    }

    public String getTime() {
        return departureTime;
    }

    public int getTotalDistance(){
        Iterator<Rail> it = rails.iterator();
        totalDistance = 0;
        while(it.hasNext()){
            totalDistance += it.next().getDistance();
        }
        return totalDistance;
    }
}

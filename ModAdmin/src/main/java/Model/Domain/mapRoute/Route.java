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

    public Route(String departureTime, String arrivalTime, Rail[] rails, Train train, int totalDistance) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.rails = new ArrayList<>(rails);
        this.train = train;
        this.totalDistance = totalDistance;
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

    public void setDepartureTime(String time) {
        this.departureTime = time;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setArrivalTime(String time) {
        this.arrivalTime = time;
    }

    public String getArrivalTime() {
        return arrivalTime;
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

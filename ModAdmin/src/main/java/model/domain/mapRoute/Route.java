package model.domain.mapRoute;

import model.domain.Train;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;

import java.io.Serializable;

public class Route implements Serializable {
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

    public Route(String departureTime, Rail[] rails, Train train) {
        this.rails = new ArrayList<>(rails);
        this.totalDistance = getTotalDistance();
        this.departureTime = departureTime;
        this.arrivalTime = calArrivalTime();
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

    public String calArrivalTime(){
        String time = departureTime;
        int hours = totalDistance / 250;
        int minutes = (totalDistance % 250) * 60 / 250;
        minutes += 20 * (rails.size());
        int hoursArrival = Integer.parseInt(time.substring(0, 2)) + hours;
        int minutesArrival = Integer.parseInt(time.substring(3, 5)) + minutes;
        if (minutesArrival >= 60) {
            hoursArrival++;
            minutesArrival -= 60;
        }
        return hoursArrival + ":" + minutesArrival;
    }
}

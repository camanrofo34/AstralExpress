package View;


import DataStructures.Interfaces.Iterator;
import DataStructures.Interfaces.List;
import Model.Domain.Train;

public class TrainView {

    public TrainView() {
    }

    public void init(List<Train> trains){
        Iterator<Train> it = trains.iterator();
        while(it.hasNext()){
            Train train = it.next();
            System.out.println("Train: " + train.getTrainName());
        }
    }


}

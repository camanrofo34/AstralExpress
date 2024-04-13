package controller;

import Model.TrainModel;
import View.TrainView;

public class TrainsManagerController {
    TrainModel trainModel;
    TrainView trainView;

    public TrainsManagerController(TrainModel trainModel, TrainView trainView) {
        this.trainModel = trainModel;
        this.trainView = trainView;
    }

    public void init() throws Exception {
        trainView.init(trainModel.getTrains());
    }
}

package controller;

import model.domain.Brand;
import model.domain.Train;
import model.TrainModel;
import view.TrainView;
import dataStructures.Array;
import dataStructures.Interfaces.List;

import javax.swing.*;
import java.util.function.UnaryOperator;

public class TrainsController {
    private TrainModel trainModel;
    private TrainView trainView;

    public TrainsController(TrainModel trainModel, TrainView trainView) {
        this.trainModel = trainModel;
        this.trainView = trainView;
    }

    /**
     * Initialize the components of the view
     * @throws Exception
     */
    public void init() throws Exception {
        trainView.init(new Array<>(new UnaryOperator[]{
                event -> {
                    try {
                        String trainSearh = trainView.getTrainSearch();
                        List<Train> trains = trainModel.getTrains();
                        trains.remove(e -> !e.getTrainName().startsWith(trainSearh));
                        trainView.chargeVagons(trains);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                },

                event -> {
                    String trainName = trainView.getTrainName();
                    String trainType = trainView.getTrainBrand();
                    String trainWagons = trainView.getTrainWagons();
                    String trainMileage = trainView.getTrainMilleage();
                    if (trainName.isEmpty() || trainType.isEmpty() || trainWagons.isEmpty() || trainMileage.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "All fields are required");
                        return null;
                    }
                    if (!trainWagons.matches("^[0-9]+$") || !trainMileage.matches("^[0-9]+(\\.[0-9]+)?$")) {
                        JOptionPane.showMessageDialog(null, "Wagons and mileage must be numeric");
                        return null;
                    }
                    if (Integer.parseInt(trainWagons) < 1 || Double.parseDouble(trainMileage) < 0) {
                        JOptionPane.showMessageDialog(null, "Wagons and mileage must be greater than 0");
                        return null;
                    }
                    if (trainType.equals("Choose")) {
                        JOptionPane.showMessageDialog(null, "Select a brand");
                        return null;
                    } else if (trainType.equals("Arnold")){
                        if (Integer.parseInt(trainWagons) > 32) {
                            JOptionPane.showMessageDialog(null, "Arnold trains can't have more than 32 wagons");
                            return null;
                        }
                    }else if (trainType.equals("Mercedez_Benz")){
                        if (Integer.parseInt(trainWagons) > 28) {
                            JOptionPane.showMessageDialog(null, "Mercedez_Benz trains can't have more than 28 wagons");
                            return null;
                        }
                    }
                    try {
                        trainModel.addTrain(trainName, Integer.parseInt(trainWagons), Double.parseDouble(trainMileage), Brand.getBrandByName(trainType));
                        List<Train> trains = trainModel.getTrains();
                        trainView.chargeVagons(trains);
                        JOptionPane.showMessageDialog(null, "Train added successfully");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                },

                event -> {
                    try {
                        Array<String> trainData = trainView.getTrainData();
                        JOptionPane.showMessageDialog(null, trainData.get(5));
                        if (!trainData.isEmpty()) {
                            Train train = new Train(trainData.get(1), trainData.get(0), Integer.parseInt(trainData.get(2)), Double.parseDouble(trainData.get(3)), Brand.getBrandByName(trainData.get(4)), Boolean.parseBoolean(trainData.get(5)));
                            JOptionPane.showMessageDialog(null, train.getInRoute());
                            if (trainModel.editTrain(train)){
                                JOptionPane.showMessageDialog(null, "Train edited successfully");
                            } else {
                                JOptionPane.showMessageDialog(null, "Train is in route");
                            }
                            List<Train> trains = trainModel.getTrains();
                            trainView.chargeVagons(trains);
                        } else {
                            JOptionPane.showMessageDialog(null, "Not selected train to edit");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                },

                event -> {
                    try {
                        Array<String> trainData = trainView.getTrainData();

                        if (!trainData.isEmpty()) {
                            Train train = new Train(trainData.get(1), trainData.get(0), Integer.parseInt(trainData.get(2)), Double.parseDouble(trainData.get(3)), Brand.getBrandByName(trainData.get(4)), Boolean.parseBoolean(trainData.get(5)));
                            JOptionPane.showMessageDialog(null, train.getInRoute());
                            if (trainModel.deleteTrain(train)){
                                JOptionPane.showMessageDialog(null, "Train deleted successfully");
                            } else {
                                JOptionPane.showMessageDialog(null, "Train is in route");
                            }
                            List<Train> trains = trainModel.getTrains();
                            trainView.chargeVagons(trains);
                        } else {
                            JOptionPane.showMessageDialog(null, "Not selected train to edit");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                }
        }), trainModel.getTrains());
    }
}

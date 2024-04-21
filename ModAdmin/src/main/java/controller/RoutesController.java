package controller;

import Model.RoutesModel;
import View.RoutesView;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

import javax.swing.*;

public class RoutesController {

    RoutesModel routesModel;
    RoutesView routesView;

    public RoutesController(RoutesModel routesModel, RoutesView routesView) {
        this.routesModel = routesModel;
        this.routesView = routesView;
    }

    public void init() throws Exception {
        routesView.initComponents (event -> {
            try {
                List<String> list = routesView.stationsSelected();
                if (list.size() < 2) {
                    JOptionPane.showMessageDialog(null, "Select at least two stations");
                    return null;
                }
                if (routesModel.createRoute(list, routesView.getSelectedTrain())){
                    JOptionPane.showMessageDialog(null, "Route created successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error creating route");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }, routesModel.getTrains());
    }
}

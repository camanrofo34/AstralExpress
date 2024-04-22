package controller;

import dataStructures.Array;
import model.RoutesModel;
import view.RoutesView;
import dataStructures.Interfaces.List;

import javax.swing.*;
import java.util.function.UnaryOperator;

public class RoutesController {

    RoutesModel routesModel;
    RoutesView routesView;

    public RoutesController(RoutesModel routesModel, RoutesView routesView) {
        this.routesModel = routesModel;
        this.routesView = routesView;
    }

    /**
     * Initialize the components of the view
     * @throws Exception
     */
    public void init() throws Exception {
        routesView.initComponents (new Array<>(new UnaryOperator[] {event -> {
            try {
                List<String> list = routesView.stationsSelected();
                if (list.size() < 2) {
                    JOptionPane.showMessageDialog(null, "Select at least two stations");
                    return null;
                }
                if (routesView.getSelectedTrain().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Select a train");
                    return null;
                }
                if (routesView.getDepartureTime().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Select a departure time");
                    return null;
                }
                if (routesModel.createRoute(list, routesView.getSelectedTrain(), routesView.getDepartureTime())) {
                    JOptionPane.showMessageDialog(null, "Route created successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error creating route, Train is already in an assigned route");
                }
                routesView.setRoutes(routesModel.getRoutes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }, event -> {
            try {
                Array<String> trains = routesView.getSelectedRow();
                if (trains.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Select a route to delete");
                    return null;
                }
                if (routesModel.deleteRoute(trains.get(4))) {
                    JOptionPane.showMessageDialog(null, "Route deleted successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error deleting route");
                }
                routesView.setRoutes(routesModel.getRoutes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }}), routesModel.getTrains(), routesModel.getRoutes());
    }
}

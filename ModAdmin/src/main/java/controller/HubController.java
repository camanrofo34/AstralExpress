package controller;

import model.*;
import model.environment.Environment;
import model.server.RMIServer;
import model.services.LogInService;
import model.services.RoutesManagerService;
import model.services.TrainManagerService;
import model.services.UserManagerService;
import view.*;
import dataStructures.Array;
import dataStructures.ArrayList;

import java.util.function.UnaryOperator;

public class HubController {
    private HubModel hubModel;
    private HubView hubView;
    private Environment environment = Environment.getInstance();
    private ArrayList<String> properties = environment.getVariables();
    private RMIServer rmiServerTLogin = new RMIServer(properties.get(0), properties.get(1), properties.get(2), new LogInService());
    private RMIServer rmiServerTrain = new RMIServer(properties.get(0), properties.get(4), properties.get(5), new TrainManagerService());
    private RMIServer rmiServerEmployee = new RMIServer(properties.get(0), properties.get(6), properties.get(7), new UserManagerService());
    private RMIServer rmiServerRoute = new RMIServer(properties.get(0), properties.get(8), properties.get(9), new RoutesManagerService());

    public HubController(HubModel hubModel, HubView hubView) throws Exception {
        this.hubModel = hubModel;
        this.hubView = hubView;
        rmiServerTrain.deploy();
        rmiServerEmployee.deploy();
        rmiServerRoute.deploy();
    }

    public void init() {
        hubView.update();
        hubView.initComponents(new Array<>(new UnaryOperator[]{
                event -> {
                    try {
                    TrainModel trainModel = new TrainModel(rmiServerTrain.getUrl());
                    TrainsController trainsManagerController = new TrainsController(trainModel, new TrainView(trainModel.getMessenger()));
                    trainsManagerController.init();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                },
                event -> {
                    try {
                        if (hubModel.getUser().getIsAdmin()) {
                            EmployeeModel employeeModel = new EmployeeModel(rmiServerEmployee.getUrl());
                            EmployeeController employeeController = new EmployeeController(employeeModel, new EmployeeView(employeeModel.getMessenger()));
                            employeeController.init();
                            hubView.update();
                            return null;
                        } else {
                            hubModel.getMessenger().setMessage("You don't have permission to access this module");
                            hubView.update();
                            return null;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                event -> {
                    try{
                        RoutesModel routesModel = new RoutesModel(rmiServerRoute.getUrl());
                        RoutesController routesController = new RoutesController(routesModel, new RoutesView(routesModel.getMessenger()));
                        routesController.init();
                        return null;
                    }catch(Exception e){
                        throw new RuntimeException(e);
                    }
                },
                event -> {
                    LoginModel loginModel = new LoginModel(rmiServerTLogin.getUrl());
                    LoginController loginController = new LoginController(loginModel, new LoginView(loginModel.getMessenger()));
                    try {
                        loginController.init();
                        hubView.close();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                }
        }));
    }
}

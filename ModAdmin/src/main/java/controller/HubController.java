package controller;

import Model.EmployeeModel;
import Model.Environment.Environment;
import Model.HubModel;
import Model.LoginModel;
import Model.Server.RMIServer;
import Model.Services.LogInService;
import Model.Services.TrainManagerService;
import Model.Services.UserManagerService;
import Model.TrainModel;
import View.EmployeeView;
import View.HubView;
import View.LoginView;
import View.TrainView;
import dataStructures.Array;
import dataStructures.ArrayList;

import java.rmi.RemoteException;
import java.util.function.UnaryOperator;

public class HubController {
    private HubModel hubModel;
    private HubView hubView;
    private Environment environment = Environment.getInstance();
    private ArrayList<String> properties = environment.getVariables();
    private RMIServer rmiServerTLogin = new RMIServer(properties.get(0), properties.get(1), properties.get(2), new LogInService());
    private RMIServer rmiServerTrain = new RMIServer(properties.get(0), properties.get(4), properties.get(5), new TrainManagerService());
    private RMIServer rmiServerEmployee = new RMIServer(properties.get(0), properties.get(6), properties.get(7), new UserManagerService());
    private RMIServer rmiServerRoute;

    public HubController(HubModel hubModel, HubView hubView) throws RemoteException {
        this.hubModel = hubModel;
        this.hubView = hubView;
        rmiServerTrain.deploy();
        rmiServerEmployee.deploy();
    }

    public void init() {
        hubView.update();
        hubView.initComponents(new Array<>(new UnaryOperator[]{
                event -> {
                    TrainModel trainModel = new TrainModel(rmiServerTrain.getUrl());
                    TrainsController trainsManagerController = new TrainsController(trainModel, new TrainView(trainModel.getMessenger()));
                    try {
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
                    hubModel.getMessenger().setMessage("Routes Management");
                    hubView.update();
                    return null;
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

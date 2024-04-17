import Model.Services.TrainManagerService;
import controller.LoginController;
import dataStructures.ArrayList;
import Model.Environment.Environment;
import Model.LoginModel;
import Model.Server.RMIServer;
import Model.Services.LogInService;
import View.LoginView;

public class Start
{
    public static Environment environment = Environment.getInstance();
    public static ArrayList<String> properties = environment.getVariables();
    public static RMIServer rmiServerLogin;

    public static void main(String[] args) throws Exception {
        rmiServerLogin = new RMIServer(properties.get(0), properties.get(1), properties.get(2), new LogInService());
        rmiServerLogin.deploy();
        LoginModel loginModel = new LoginModel(rmiServerLogin.getUrl());
        LoginController loginController = new LoginController(loginModel, new LoginView(loginModel.getMessenger()));
        loginController.init();
    }
}

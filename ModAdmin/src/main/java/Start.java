import model.environment.Environment;
import model.LoginModel;
import model.server.RMIServer;
import model.services.LogInService;
import view.LoginView;
import controller.LoginController;
import dataStructures.ArrayList;

public class Start {
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

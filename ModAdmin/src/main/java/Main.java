import controller.LoginController;
import controller.TrainsManagerController;
import DataStructures.ArrayList;
import Model.Environment.Environment;
import Model.LoginModel;
import Model.Server.RMIServer;
import Model.Services.LogInService;
import Model.Services.TrainManagerService;
import Model.TrainModel;
import View.LoginView;
import View.TrainView;

public class Main
{
    static Environment environment = Environment.getInstance();
    static ArrayList<String> properties = environment.getVariables();

    public static void main(String[] args) throws Exception {
        RMIServer rmiServerLogin = new RMIServer(properties.get(0), properties.get(1), properties.get(2), new LogInService());
        rmiServerLogin.deploy();
        LoginController loginController = new LoginController(new LoginModel(rmiServerLogin.getUrl()), new LoginView());
        loginController.init();
        RMIServer rmiServerTrainsManager = new RMIServer(properties.get(0), properties.get(4), properties.get(5), new TrainManagerService());
        rmiServerTrainsManager.deploy();
        TrainsManagerController trainsManagerController = new TrainsManagerController(new TrainModel(rmiServerTrainsManager.getUrl()), new TrainView());
        trainsManagerController.init();
    }
}

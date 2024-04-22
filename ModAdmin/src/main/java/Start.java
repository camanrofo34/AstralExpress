import model.environment.Environment;
import model.LoginModel;
import model.server.RMIServer;
import model.services.LogInService;
import model.services.TicketManagerService;
import view.LoginView;
import controller.LoginController;
import dataStructures.ArrayList;

public class Start {
    public static Environment environment = Environment.getInstance();
    public static ArrayList<String> properties = environment.getVariables();
    public static RMIServer rmiServerLogin;
    public static RMIServer rmiServerTicket;

    /**
     * Main method to start the server
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        rmiServerLogin = new RMIServer(properties.get(0), properties.get(1), properties.get(2), new LogInService());
        rmiServerTicket = new RMIServer(properties.get(0), properties.get(10), properties.get(11), new TicketManagerService());
        rmiServerLogin.deploy();
        rmiServerTicket.deploy();
        LoginModel loginModel = new LoginModel(rmiServerLogin.getUrl());
        LoginController loginController = new LoginController(loginModel, new LoginView(loginModel.getMessenger()));
        loginController.init();
    }
}

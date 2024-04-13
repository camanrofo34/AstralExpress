package Model.Services;
import DataStructures.ArrayList;
import Model.CRUD.Repository.UserRepository;
import Model.Domain.User;
import Model.Environment.Environment;
import Model.Interfaces.CRUD.UserRepoInterface;
import Model.Interfaces.Communication.SendToClient.LoginInterface;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LogInService extends UnicastRemoteObject implements LoginInterface {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String jsonUsersPath;

    public LogInService() throws RemoteException {
        super();
        ArrayList<String> properties = Environment.getInstance().getVariables();
        jsonUsersPath = properties.get(3) + "users.json";
    }

    @Override
    public Boolean login(String user, String password) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        User userToLogIn = userRepo.getUser(user);
        return userToLogIn.getPassword().equals(password);
    }
}

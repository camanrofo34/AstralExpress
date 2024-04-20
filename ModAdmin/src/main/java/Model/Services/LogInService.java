package Model.Services;

import Model.CRUD.Repository.UserRepository;
import Model.Domain.User;
import Model.Environment.Environment;
import Model.Interfaces.CRUD.UserRepoInterface;
import Model.Interfaces.Communication.SendToClient.LoginInterface;
import dataStructures.ArrayList;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LogInService extends UnicastRemoteObject implements LoginInterface {
    @Serial
    private static final long serialVersionUID = 1L;

    public static User loggedUser;

    private final String jsonUsersPath;

    public LogInService() throws RemoteException {
        super();
        ArrayList<String> properties = Environment.getInstance().getVariables();
        jsonUsersPath = properties.get(3) + "users.json";
    }

    @Override
    public Boolean login(String user, String password) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        loggedUser = userRepo.getUser(user);
        return loggedUser.getPassword().equals(password);
    }

    @Override
    public User getUser() throws Exception {
        return loggedUser;
    }
}

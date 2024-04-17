package Model.Services;

import dataStructures.ArrayList;
import dataStructures.Interfaces.List;
import Model.Domain.User;
import Model.Environment.Environment;
import Model.Interfaces.Communication.SendToClient.UserManagerClientInterface;
import Model.Interfaces.Communication.SendToServer.UserManagerServerInterface;
import Model.Interfaces.CRUD.UserRepoInterface;
import Model.CRUD.Repository.UserRepository;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserManagerService extends UnicastRemoteObject implements UserManagerServerInterface, UserManagerClientInterface {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String jsonUsersPath;

    public UserManagerService() throws RemoteException {
        super();
        ArrayList<String> properties = Environment.getInstance().getVariables();
        jsonUsersPath = properties.get(3) + "users.json";
    }

    @Override
    public List<User> getUsers() throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        return userRepo.getUsers();
    }

    @Override
    public Boolean addUser(User user) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        return userRepo.insert(user);
    }

    @Override
    public Boolean removeUser(User user) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        return userRepo.delete(user);
    }

    @Override
    public Boolean updateUser(User user) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        return userRepo.update(user);
    }
}

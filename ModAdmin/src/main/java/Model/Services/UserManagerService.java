package Model.Services;

import Model.CRUD.Repository.UserRepository;
import Model.Domain.Employee;
import Model.Domain.User;
import Model.Environment.Environment;
import Model.Environment.IdGenerator;
import Model.Interfaces.CRUD.UserRepoInterface;
import Model.Interfaces.Communication.SendToClient.UserManagerClientInterface;
import Model.Interfaces.Communication.SendToServer.UserManagerServerInterface;
import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

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
    public Boolean addUser(String userName, String password, String names, String lastNames, Array<String> phoneNumbers) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        String id = IdGenerator.generateEmployeeId();
        User user = new User(userName, password, false, new Employee("E" + id, names, lastNames, phoneNumbers));
        List<User> users = userRepo.getUsers();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user1 = iterator.next();
            if (user1.getUsername().equals(userName)) {
                return false;
            }
        }
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

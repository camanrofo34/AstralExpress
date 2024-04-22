package model.services;

import model.crud.repository.UserRepository;
import model.domain.Employee;
import model.domain.User;
import model.environment.Environment;
import model.environment.IdGenerator;
import model.interfaces.crud.UserRepoInterface;
import model.interfaces.communication.sendToClient.UserManagerClientInterface;
import model.interfaces.communication.sendToServer.UserManagerServerInterface;
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
    /**
     * Constructor
     * @throws RemoteException
     */
    public UserManagerService() throws RemoteException {
        super();
        ArrayList<String> properties = Environment.getInstance().getVariables();
        jsonUsersPath = properties.get(3) + "users.json";
    }
    /**
     * Method to get the users
     * @return
     * @throws Exception
     */
    @Override
    public List<User> getUsers() throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        return userRepo.getUsers();
    }
    /**
     * Method to add a user
     * @param userName
     * @param password
     * @param names
     * @param lastNames
     * @param phoneNumbers
     * @return
     * @throws Exception
     */
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
    /**
     * Method to remove a user
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Boolean removeUser(User user) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        return userRepo.delete(user);
    }
    /**
     * Method to update a user
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Boolean updateUser(User user) throws Exception {
        UserRepoInterface userRepo = new UserRepository(jsonUsersPath);
        return userRepo.update(user);
    }
}

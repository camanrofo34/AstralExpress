package model;

import model.domain.User;
import model.interfaces.communication.sendToClient.UserManagerClientInterface;
import model.interfaces.communication.sendToServer.UserManagerServerInterface;
import model.messenger.Messenger;
import dataStructures.Array;
import dataStructures.Interfaces.List;

import java.rmi.Naming;

public class EmployeeModel {
    private final String uri;
    private Messenger messenger;

    public EmployeeModel(String uri) {
        this.uri = uri;
        messenger = new Messenger("");
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public List<User> getEmployees() throws Exception {
        UserManagerClientInterface userManagerClientInterface = (UserManagerClientInterface) Naming.lookup(uri);
        List<User> users = userManagerClientInterface.getUsers();
        users.remove(User::getIsAdmin);
        return users;
    }

    public Boolean addEmployee(String userName, String password, String names, String lastNames, Array<String> phoneNumbers) throws Exception {
        UserManagerServerInterface userManagerClientInterface = (UserManagerServerInterface) Naming.lookup(uri);
        return userManagerClientInterface.addUser(userName, password, names, lastNames, phoneNumbers);
    }

    public Boolean editEmployee(User user) throws Exception {
        UserManagerServerInterface userManagerClientInterface = (UserManagerServerInterface) Naming.lookup(uri);
        return userManagerClientInterface.updateUser(user);
    }

    public Boolean deleteEmployee(User user) throws Exception {
        UserManagerServerInterface userManagerClientInterface = (UserManagerServerInterface) Naming.lookup(uri);
        return userManagerClientInterface.removeUser(user);
    }
}

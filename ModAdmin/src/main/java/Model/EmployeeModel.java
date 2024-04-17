package Model;

import Model.Domain.User;
import Model.Interfaces.Communication.SendToClient.UserManagerClientInterface;
import Model.Interfaces.Communication.SendToServer.UserManagerServerInterface;
import Model.Messenger.Messenger;
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
        return userManagerClientInterface.getUsers();
    }

    public Boolean addEmployee(User user) throws Exception {
        UserManagerServerInterface userManagerClientInterface = (UserManagerServerInterface) Naming.lookup(uri);
        return userManagerClientInterface.addUser(user);
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

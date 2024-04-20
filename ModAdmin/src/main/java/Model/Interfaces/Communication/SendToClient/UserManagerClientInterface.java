package Model.Interfaces.Communication.SendToClient;

import Model.Domain.User;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface UserManagerClientInterface extends Remote {

    List<User> getUsers() throws Exception;

}

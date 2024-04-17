package Model.Interfaces.Communication.SendToClient;

import dataStructures.Interfaces.List;
import Model.Domain.User;

import java.rmi.Remote;

public interface UserManagerClientInterface extends Remote {

    List<User> getUsers() throws Exception;

}

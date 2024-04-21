package model.interfaces.communication.sendToClient;

import model.domain.User;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface UserManagerClientInterface extends Remote {

    List<User> getUsers() throws Exception;

}

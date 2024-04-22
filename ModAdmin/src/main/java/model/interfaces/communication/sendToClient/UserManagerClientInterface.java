package model.interfaces.communication.sendToClient;

import model.domain.User;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface UserManagerClientInterface extends Remote {
    /**
     * Get the Users
     * @return
     * @throws Exception
     */
    List<User> getUsers() throws Exception;

}

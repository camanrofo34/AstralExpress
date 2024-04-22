package model.interfaces.communication.sendToServer;

import model.domain.User;
import dataStructures.Array;

import java.rmi.Remote;

public interface UserManagerServerInterface extends Remote {
    /**
     * Add a user
     * @param userName
     * @param password
     * @param names
     * @param lastNames
     * @param phoneNumbers
     * @return
     * @throws Exception
     */
    Boolean addUser(String userName, String password, String names, String lastNames, Array<String> phoneNumbers) throws Exception;
    /**
     * Remove a user
     * @param user
     * @return
     * @throws Exception
     */
    Boolean removeUser(User user) throws Exception;
    /**
     * Update a user
     * @param user
     * @return
     * @throws Exception
     */
    Boolean updateUser(User user) throws Exception;
}

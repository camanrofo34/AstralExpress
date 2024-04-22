package model.interfaces.communication.sendToClient;

import model.domain.User;

import java.rmi.Remote;

public interface LoginInterface extends Remote {
    /**
     * Login
     * @param user
     * @param password
     * @return
     * @throws Exception
     */
    Boolean login(String user, String password) throws Exception;

    /**
     * Get user
     * @return
     * @throws Exception
     */
    User getUser() throws Exception;
}

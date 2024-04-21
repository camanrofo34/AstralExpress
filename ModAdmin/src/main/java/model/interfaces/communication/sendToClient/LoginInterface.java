package model.interfaces.communication.sendToClient;

import model.domain.User;

import java.rmi.Remote;

public interface LoginInterface extends Remote {

    Boolean login(String user, String password) throws Exception;

    User getUser() throws Exception;
}

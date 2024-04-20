package Model.Interfaces.Communication.SendToClient;

import Model.Domain.User;

import java.rmi.Remote;

public interface LoginInterface extends Remote {

    Boolean login(String user, String password) throws Exception;

    User getUser() throws Exception;
}

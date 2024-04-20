package Model.Interfaces.Communication.SendToServer;

import Model.Domain.User;
import dataStructures.Array;

import java.rmi.Remote;

public interface UserManagerServerInterface extends Remote {

    Boolean addUser(String userName, String password, String names, String lastNames, Array<String> phoneNumbers) throws Exception;

    Boolean removeUser(User user) throws Exception;

    Boolean updateUser(User user) throws Exception;
}

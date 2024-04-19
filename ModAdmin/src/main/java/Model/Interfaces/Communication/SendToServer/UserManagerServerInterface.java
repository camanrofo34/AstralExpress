package Model.Interfaces.Communication.SendToServer;

import java.rmi.Remote;
import Model.Domain.User;
import dataStructures.Array;

public interface UserManagerServerInterface extends Remote {

    Boolean addUser(String userName, String password, String names, String lastNames, Array<String> phoneNumbers) throws Exception;

    Boolean removeUser(User user) throws Exception;

    Boolean updateUser(User user) throws Exception;
}

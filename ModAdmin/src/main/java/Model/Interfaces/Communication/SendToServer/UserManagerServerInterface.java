package Model.Interfaces.Communication.SendToServer;

import java.rmi.Remote;
import Model.Domain.User;

public interface UserManagerServerInterface extends Remote {

    Boolean addUser(User user) throws Exception;

    Boolean removeUser(User user) throws Exception;

    Boolean updateUser(User user) throws Exception;
}

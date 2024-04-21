package model.interfaces.CRUD;

import model.domain.User;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface UserRepoInterface extends Remote {
    Boolean insert(User user) throws Exception;

    Boolean delete(User user) throws Exception;

    Boolean update(User user) throws Exception;

    User getUser(String username) throws Exception;

    List<User> getUsers() throws Exception;
}

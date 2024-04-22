package model.interfaces.crud;

import model.domain.User;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface UserRepoInterface extends Remote {
    /**
     * Insert a User in the repository
     * @param user User to be inserted
     * @return true if the User was inserted, false if not
     */
    Boolean insert(User user) throws Exception;

    /**
     * Delete a User in the repository
     * @param user User to be deleted
     * @return true if the User was deleted, false if not
     */
    Boolean delete(User user) throws Exception;
    /**
     * Update a User in the repository
     * @param user User to be updated
     * @return true if the User was updated, false if not
     */
    Boolean update(User user) throws Exception;
    /**
     * Get a User from the repository
     * @param username User to be obtained
     * @return User if the User was found, null if not
     */
    User getUser(String username) throws Exception;
    /**
     * Get all Users from the repository
     * @return List of Users
     */
    List<User> getUsers() throws Exception;
}

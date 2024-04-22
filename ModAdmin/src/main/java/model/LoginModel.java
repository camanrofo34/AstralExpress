package model;

import model.domain.User;
import model.interfaces.communication.sendToClient.LoginInterface;
import model.messenger.Messenger;

import java.rmi.Naming;

public class LoginModel {
    private final String uri;
    private Messenger messenger;
    /**
     * Constructor
     * @param uri
     */
    public LoginModel(String uri) {
        this.uri = uri;
        messenger = new Messenger("");
    }
    /**
     * Method to login
     * @param user
     * @param password
     * @return
     * @throws Exception
     */
    public Boolean login(String user, String password) throws Exception {
        LoginInterface loginInterface = (LoginInterface) Naming.lookup(uri);
        return loginInterface.login(user, password);
    }
    /**
     * Method to get the user
     * @return
     * @throws Exception
     */
    public User getUser() throws Exception {
        LoginInterface loginInterface = (LoginInterface) Naming.lookup(uri);
        return loginInterface.getUser();
    }
    /**
     * Method to return the uri
     * @return
     */
    public String retunUri() {
        return uri;
    }
    /**
     * Method to get the messenger
     * @return
     */
    public Messenger getMessenger() {
        return messenger;
    }

}

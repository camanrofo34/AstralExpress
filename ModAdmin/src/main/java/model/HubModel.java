package model;

import model.domain.User;
import model.interfaces.communication.sendToClient.LoginInterface;
import model.messenger.Messenger;

import java.rmi.Naming;

public class HubModel {

    private final String uri;
    private Messenger messenger;
    private User user;
    /**
     * Constructor
     * @param uri
     * @param user
     * @throws Exception
     */
    public HubModel(String uri, User user) throws Exception {
        this.uri = uri;
        messenger = new Messenger("Bienvenido, " + getUser().getUsername() + " !");
        this.user = user;
    }
    /**
     * Method to get the messenger
     * @return
     */
    public Messenger getMessenger() {
        return messenger;
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


}

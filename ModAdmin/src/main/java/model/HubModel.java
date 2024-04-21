package model;

import model.domain.User;
import model.interfaces.communication.sendToClient.LoginInterface;
import model.messenger.Messenger;

import java.rmi.Naming;

public class HubModel {

    private final String uri;
    private Messenger messenger;
    private User user;

    public HubModel(String uri, User user) throws Exception {
        this.uri = uri;
        messenger = new Messenger("Bienvenido, " + getUser().getUsername() + " !");
        this.user = user;
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public User getUser() throws Exception {
        LoginInterface loginInterface = (LoginInterface) Naming.lookup(uri);
        return loginInterface.getUser();
    }


}

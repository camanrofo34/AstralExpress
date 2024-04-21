package model;

import model.domain.User;
import model.interfaces.communication.sendToClient.LoginInterface;
import model.messenger.Messenger;

import java.rmi.Naming;

public class LoginModel {
    private final String uri;
    private Messenger messenger;

    public LoginModel(String uri) {
        this.uri = uri;
        messenger = new Messenger("");
    }

    public Boolean login(String user, String password) throws Exception {
        LoginInterface loginInterface = (LoginInterface) Naming.lookup(uri);
        return loginInterface.login(user, password);
    }

    public User getUser() throws Exception {
        LoginInterface loginInterface = (LoginInterface) Naming.lookup(uri);
        return loginInterface.getUser();
    }

    public String retunUri() {
        return uri;
    }

    public Messenger getMessenger() {
        return messenger;
    }

}

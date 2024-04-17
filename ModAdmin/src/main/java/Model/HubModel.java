package Model;

import Model.Domain.User;
import Model.Interfaces.Communication.SendToClient.LoginInterface;
import Model.Messenger.Messenger;

import java.rmi.Naming;

public class HubModel {

    private final String uri;
    private Messenger messenger;

    public HubModel(String uri) throws Exception {
        this.uri = uri;
        messenger = new Messenger("Bienvenido, " + getUser().getUsername() + " !");
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public User getUser() throws Exception {
        LoginInterface loginInterface = (LoginInterface) Naming.lookup(uri);
        return loginInterface.getUser();
    }


}

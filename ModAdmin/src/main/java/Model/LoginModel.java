package Model;

import Model.Interfaces.Communication.SendToClient.LoginInterface;

import java.rmi.Naming;

public class LoginModel {
    private final String uri;
    public LoginModel(String uri) {
        this.uri = uri;
    }

    public Boolean login(String user, String password) throws Exception {
        LoginInterface loginInterface = (LoginInterface) Naming.lookup(uri);
        return loginInterface.login(user, password);
    }

}

package controller;

import Model.LoginModel;
import View.LoginView;

public class LoginController {
    LoginModel loginModel;
    LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
    }

    public void init() throws Exception {
        loginView.init();
        System.out.println(loginModel.login(loginView.getUsername(), loginView.getPassword()) ? "Login correcto" : "Login incorrecto");
    }
}

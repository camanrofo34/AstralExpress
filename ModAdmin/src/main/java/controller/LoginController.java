package controller;

import Model.Domain.User;
import Model.HubModel;
import Model.LoginModel;
import View.HubView;
import View.LoginView;

public class LoginController {
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
    }

    public void init() throws Exception {
        loginView.initComponents(event ->
        {
            String user = loginView.getUser();
            String password = loginView.getPassword();
            if (user.isBlank() || password.isBlank()){
                loginModel.getMessenger().setMessage("User or password is empty");
                return null;
            }
            try {
                if (loginModel.login(user, password)) {
                    User user1 = loginModel.getUser();
                    HubModel hubModel = new HubModel(loginModel.retunUri(), user1);
                    HubController hubController = new HubController(hubModel, new HubView(hubModel.getMessenger()));
                    hubController.init();
                    loginModel.getMessenger().setMessage("Login successful");
                    loginView.close();
                } else {
                    loginModel.getMessenger().setMessage("Login failed");
                }
            } catch (Exception e) {
                loginModel.getMessenger().setMessage("Login failed");
            }
            return null;
        });
    }
}

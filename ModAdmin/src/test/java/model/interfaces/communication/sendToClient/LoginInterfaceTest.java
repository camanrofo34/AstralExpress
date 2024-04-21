package model.interfaces.communication.sendToClient;

import model.services.LogInService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginInterfaceTest {

    @Test
    void login() throws Exception {
        LoginInterface loginInterface = new LogInService();
        assertTrue(loginInterface.login("root", "admin"));
    }
}
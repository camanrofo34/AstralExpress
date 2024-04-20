package Model.Interfaces.Communication.SendToClient;

import Model.Services.LogInService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginInterfaceTest {

    @Test
    void login() throws Exception {
        LoginInterface loginInterface = new LogInService();
        assertTrue(loginInterface.login("admin1", "admin"));
    }
}
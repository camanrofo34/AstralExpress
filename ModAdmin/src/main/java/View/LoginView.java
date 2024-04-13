package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginView {
    String username;
    String password;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void init() throws IOException {
        System.out.println("Usuario: ");
        username = br.readLine();
        System.out.println("Contraseña: ");
        password = br.readLine();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.astralexpress.controlador.LoginController;
import org.astralexpress.modelo.LoginModel;
import org.astralexpress.modelo.RMISettings;
import org.astralexpress.vista.LoginView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author PC 4060TI
 */
public class ModuloGestionCentral {

    public static void main(String[] args) {
        RMISettings RMIS = RMISettings.getInstance();
        LoginModel LM = new LoginModel (RMIS.getRMIAddress());
            LoginController controller = new LoginController(LM, new LoginView(LM.getMessenger()));
            controller.start();
    }
    
}

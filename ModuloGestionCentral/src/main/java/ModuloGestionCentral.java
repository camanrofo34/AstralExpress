
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.astralexpress.controlador.LoginController;
import org.astralexpress.modelo.LoginModel;
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
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("config.properties"))) {
            config.load(fin);
            LoginModel model = new LoginModel(
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICE_NAME"));
            LoginController controller = new LoginController(model, new LoginView());
            controller.start();
        } catch (Exception e) {
            Logger.getLogger("AuthServer").log(Level.WARNING, e.getMessage(), e);
        }
    }
    
}

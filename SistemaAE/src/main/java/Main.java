
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.astralexpress.controlador.AstralExpressController;
import org.astralexpress.modelo.AstralExpressModel;
import org.astralexpress.vista.ServerView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC 4060TI
 */
public class Main {
        public static void main(String[] args){
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("config.properties"))) {
            config.load(fin);
            AstralExpressModel model = new AstralExpressModel(
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICE_NAME"));
            AstralExpressController controller = new AstralExpressController(model, new ServerView(model.getMessenger()));
            controller.start();
        } catch (Exception e) {
            Logger.getLogger("AuthServer").log(Level.WARNING, e.getMessage(), e);
        }
    }
}

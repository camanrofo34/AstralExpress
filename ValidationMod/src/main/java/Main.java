import controller.DischargeController;
import controller.ValidationController;
import model.DischargeModel;
import model.ValidationModel;
import view.DischargeView;
import view.ValidationView;

public class Main {
    public static void main(String[] args) {
        ValidationModel validationModel = new ValidationModel("//192.168.10.1:2004/tickets");
        DischargeModel dischargeModel = new DischargeModel("//192.168.10.1:2004/tickets");
        ValidationController validationController = new ValidationController(validationModel, new ValidationView());
        DischargeController dischargeController = new DischargeController(dischargeModel, new DischargeView());
        dischargeController.init();
        validationController.init();
    }
}

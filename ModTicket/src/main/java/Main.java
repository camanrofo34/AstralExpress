import controller.TicketController;
import model.TicketModel;
import view.TicketView;
public class Main {
    public static void main(String[] args) {
        TicketModel ticketModel = new TicketModel("//192.168.1.5:2004/tickets");
        TicketView ticketView = new TicketView();
        TicketController ticketController = new TicketController(ticketModel, ticketView);
        ticketController.init();
    }
}

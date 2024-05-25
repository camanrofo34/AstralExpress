import controller.QueueTController;
import controller.TicketController;
import model.QueueTModel;
import model.TicketModel;
import view.QueueTView;
import view.TicketView;

public class Main {
    public static void main(String[] args) {
        TicketModel ticketModel = new TicketModel("//192.168.10.1:2004/tickets");
        QueueTModel queueTModel = new QueueTModel("//192.168.10.1:2004/tickets");
        TicketView ticketView = new TicketView();
        QueueTView queueTView = new QueueTView();
        TicketController ticketController = new TicketController(ticketModel, ticketView);
        QueueTController queueTController = new QueueTController(queueTModel, queueTView);
        ticketController.init();
        queueTController.init();
    }
}

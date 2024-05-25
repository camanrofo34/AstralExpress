package controller;

import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.ValidationModel;
import model.domain.Ticket;
import view.ValidationView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ValidationController {
    ValidationModel validationModel;
    ValidationView validationView;

    public ValidationController(ValidationModel validationModel, ValidationView validationView) {
        this.validationModel = validationModel;
        this.validationView = validationView;
    }
    /**
     * This method is used to initialize the view
     */
    public void init() {
        validationView.init(event ->{
            String id = validationView.getUserField();
            try {
                List<Ticket> tickets = validationModel.getTicketSearch(id);
                chargeTable(tickets);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }
    /**
     * This method is used to charge the table
     * @param tickets - List of tickets
     */
    public void chargeTable(List<Ticket> tickets) {
        JTable table = validationView.getjTable1();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            Object[] row = {ticket.getIdTicket(), ticket.getPassenger().getNames(), ticket.getPassenger().getLastNames(), ticket.getStations().toString(), ticket.getTrains().toString()};
            model.addRow(row);
        }
        validationView.chargeTickets(model);
    }
}

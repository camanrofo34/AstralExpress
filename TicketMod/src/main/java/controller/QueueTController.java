package controller;

import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.QueueTModel;
import model.domain.Ticket;
import view.QueueTView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QueueTController {
    QueueTModel queueTModel;
    QueueTView queueTView;

    public QueueTController(QueueTModel queueTModel, QueueTView queueTView) {
        this.queueTModel = queueTModel;
        this.queueTView = queueTView;
    }
    /**
     * This method is used to initialize the view
     */
    public void init() {
        queueTView.init(event -> {
            try {
                String id = queueTView.getSearchField();
                queueTModel.getPerTrainId(id);
                chargeTable(queueTModel.getPerTrainId(id), id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return null;
        });
    }
    /**
     * This method is used to charge the table
     * @param tickets - List of tickets
     * @param searchfield - Search field
     */
    public void chargeTable(List<Ticket> tickets, String searchfield) {
        JTable table = queueTView.getjTable1();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            Object[] row = {ticket.getIdTicket(), searchfield, ticket.getClasse().toString()};
            model.addRow(row);
        }
        queueTView.chargeData(model);
    }
}

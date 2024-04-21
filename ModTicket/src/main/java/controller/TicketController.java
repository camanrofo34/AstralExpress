package controller;

import dataStructures.Array;
import dataStructures.Interfaces.List;
import model.TicketModel;
import view.TicketView;

public class TicketController {
    TicketModel ticketModel;
    TicketView ticketView;

    public TicketController(TicketModel ticketModel, TicketView ticketView) {
        this.ticketModel = ticketModel;
        this.ticketView = ticketView;
    }

    public void init(){
        ticketView.init(event -> {
            try {
                String names = ticketView.names();
                String lastName = ticketView.lastName();
                String idType = ticketView.idType();
                String idNumber = ticketView.idNumber();
                String address = ticketView.address();
                Array<String> phone = new Array<>(ticketView.phoneNumber().split(","));
                String seatType = ticketView.seatType();
                String contactName = ticketView.contactPersonNames();
                String contactPhones = ticketView.contactPersonPhoneNumber();
                String weight = ticketView.luggageWeight();
                if (ticketView.customRoute()){
                    List<String> stations = ticketView.stationsSelected();
                } else{
                    List<String> stations =
                }



                ticketModel.buyTicket();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        );
    }
}

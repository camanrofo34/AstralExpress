package controller;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.TicketModel;
import model.domain.Station;
import model.domain.Train;
import view.TicketView;

import javax.swing.*;

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
                if (names.isBlank() || lastName.isBlank() || idType.isBlank() || idNumber.isBlank() || address.isBlank() || phone.isEmpty() || seatType.isBlank() || contactName.isBlank() || contactPhones.isBlank() || weight.isBlank()){
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    return null;
                }
                if (Double.parseDouble(weight) > 80){
                    JOptionPane.showMessageDialog(null, "The luggage weight cannot be more than 80");
                    return null;
                }
                List<String> stations = new ArrayList<>();
                if (ticketView.customRoute()){
                    stations = ticketView.stationsSelected();
                } else{
                    Station station1 = ticketModel.getStation(ticketView.initialStation());
                    Station station2 = ticketModel.getStation(ticketView.finalStation());
                    stations = ticketModel.getStationsForShortPath(station1, station2);
                }
                List<Train> trains = ticketModel.getTrains(stations);
                ticketModel.buyTicket(names, lastName, idType, idNumber, address, phone, seatType, contactName, contactPhones, weight, trains, stations);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        );
    }
}

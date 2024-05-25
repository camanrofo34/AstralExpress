package controller;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.List;
import model.TicketModel;
import model.domain.Station;
import model.domain.Ticket;
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
    /**
     * This method is used to initialize the view
     */
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
                        Ticket ticket = ticketModel.buyTicket(names, lastName, idType, idNumber, address, phone, seatType, contactName, contactPhones, weight, trains, stations);
                        if (ticket != null){
                            JOptionPane.showMessageDialog(null, "Ticket bought successfully");
                            JOptionPane.showMessageDialog(null, "Ticket ID: " + ticket.getIdTicket() +
                                    "\n" +  "Price: " + ticket.getPrice() + "\n" + "Departure: "
                                    + ticket.getDepartureTime() + "\n" + "Arrival: " + ticket.getArrivalTime() + "\n" + "Contact Name: "
                                    + ticket.getPassengerContact().getNames() + "\n" + "Contact Phones: " + ticket.getPassengerContact().getPhoneNumbersString() + "\n" +
                                    "Weight: " + ticket.getLuggage().getWeight() + "\n" + "Date: " +
                                    ticket.getDateOfPurchase() +  "\n" + "Type: " + ticket.getIdType().toString() +
                                    "\n" + "Names: " + ticket.getPassenger().getNames() + "\n" + "Last Name: " + ticket.getPassenger().getLastNames() + "\n" +
                                    "ID Type: " + ticket.getIdType().toString() + "\n" + "ID Number: " + ticket.getPassenger().getIdPerson() + "\n" +
                                    "Address: " + ticket.getPassenger().getHomeAdress() + "\n" + "Phone: " + ticket.getPassenger().getPhoneNumbersString() +
                                     "\n" + "Stations: " + ticket.getStations().toArray(new String[]{}).toString() + "\n" + "Trains: " + ticket.getTrains().toArray(new String[]{}).toString() + "\n");

                        } else{
                            JOptionPane.showMessageDialog(null, "There was an error buying the ticket, no routes or complete trains");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
        );
    }
}

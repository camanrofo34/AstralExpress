package model.domain;

import dataStructures.Interfaces.List;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String idTicket;
    private String dateOfPurchase;
    private String departureTime;
    private String arrivalTime;
    private Passenger passenger;
    private PassengerContact passengerContact;
    private String idPassenger;
    private IdType idType;
    private Double price;
    private Classe classe;
    private Luggage luggage;
    private List<String> trains;
    private List<String> passengerVagons;
    private List<String> chargeVagons;
    private List<String> stations;

    public Ticket(String idTicket, String dateOfPurchase, String departureTime, String arrivalTime, Passenger passenger, PassengerContact passengerContact, String idPassenger, IdType idType, Double price, Classe classe, Luggage luggage, List<String> trains, List<String> passengerVagons, List<String> chargeVagons, List<String> stations) {
        this.idTicket = idTicket;
        this.dateOfPurchase = dateOfPurchase;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.passenger = passenger;
        this.passengerContact = passengerContact;
        this.idPassenger = idPassenger;
        this.idType = idType;
        this.price = price;
        this.classe = classe;
        this.luggage = luggage;
        this.trains = trains;
        this.passengerVagons = passengerVagons;
        this.chargeVagons = chargeVagons;
        this.stations = stations;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(String idPassenger) {
        this.idPassenger = idPassenger;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public List<String> getTrains() {
        return trains;
    }

    public void setTrains(List<String> trains) {
        this.trains = trains;
    }

    public List<String> getPassengerVagons() {
        return passengerVagons;
    }

    public void setPassengerVagons(List<String> passengerVagons) {
        this.passengerVagons = passengerVagons;
    }

    public List<String> getChargeVagons() {
        return chargeVagons;
    }

    public void setChargeVagons(List<String> chargeVagons) {
        this.chargeVagons = chargeVagons;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public PassengerContact getPassengerContact() {
        return passengerContact;
    }

    public void setPassengerContact(PassengerContact passengerContact) {
        this.passengerContact = passengerContact;
    }
}

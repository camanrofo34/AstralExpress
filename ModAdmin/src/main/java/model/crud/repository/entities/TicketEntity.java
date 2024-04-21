package model.crud.repository.entities;

import model.domain.*;

public class TicketEntity {
    private String idTicket;
    private String dateOfPurchase;
    private String departureTime;
    private String arrivalTime;
    private Passenger passenger;
    private PassengerContact passengerContact;
    private String idPassenger;
    private String idType;
    private float price;
    private String classe;
    private Luggage luggage;
    private Train[] trains;
    private Station[] stations;

    public TicketEntity(String idTicket, String dateOfPurchase, String departureTime, String arrivalTime, Passenger passenger, PassengerContact passengerContact, String idPassenger, String idType, float price, String classe, Luggage luggage, Train[] trains, Station[] stations) {
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

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public Train[] getTrains() {
        return trains;
    }

    public void setTrains(Train[] trains) {
        this.trains = trains;
    }

    public Station[] getStations() {
        return stations;
    }

    public void setStations(Station[] stations) {
        this.stations = stations;
    }

    public PassengerContact getPassengerContact() {
        return passengerContact;
    }

    public void setPassengerContact(PassengerContact passengerContact) {
        this.passengerContact = passengerContact;
    }
}

package model;

import java.time.LocalDateTime;

public class TicketModel {

    private int ticketID;
    private String serie;
    private LocalDateTime createdAt;
    private int orderID;

    public TicketModel(int ticketID, String serie, LocalDateTime createdAt, int orderID) {
        this.ticketID = ticketID;
        this.serie = serie;
        this.createdAt = createdAt;
        this.orderID = orderID;
    }

    public TicketModel(String serie, LocalDateTime createdAt, int orderID) {
        this.serie = serie;
        this.createdAt = createdAt;
        this.orderID = orderID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "TicketModel{" + "ticketID=" + ticketID + ", serie=" + serie + ", createdAt=" + createdAt + ", orderID=" + orderID + '}';
    }

}

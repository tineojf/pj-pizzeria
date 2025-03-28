package dto;

import java.time.LocalDateTime;

public class TicketDTO {

    private String serie;
    private String customerName;
    private String customerDNI;
    private LocalDateTime createdAt;
    private double orderTotal;

    public TicketDTO(String serie, String customerName, String customerDNI, LocalDateTime createdAt, double orderTotal) {
        this.serie = serie;
        this.customerName = customerName;
        this.customerDNI = customerDNI;
        this.createdAt = createdAt;
        this.orderTotal = orderTotal;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDNI() {
        return customerDNI;
    }

    public void setCustomerDNI(String customerDNI) {
        this.customerDNI = customerDNI;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

}

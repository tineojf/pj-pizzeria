package model;

public class OrderDTO {

    private int orderID;
    private String customer;
    private String pizza;
    private int quantity;
    private double total;

    public OrderDTO(int orderID, String customer, String pizza, int quantity, double total) {
        this.orderID = orderID;
        this.customer = customer;
        this.pizza = pizza;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

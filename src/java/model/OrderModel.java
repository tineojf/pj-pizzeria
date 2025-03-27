package model;

public class OrderModel {

    private int orderID;
    private int quantity;
    private Double total;
    private int state;
    private int customerID;
    private int pizzaID;

    public OrderModel(int orderID, int quantity, Double total, int state, int customerID, int pizzaID) {
        this.orderID = orderID;
        this.quantity = quantity;
        this.total = total;
        this.state = state;
        this.customerID = customerID;
        this.pizzaID = pizzaID;
    }

    public OrderModel(int quantity, Double total, int state, int customerID, int pizzaID) {
        this.quantity = quantity;
        this.total = total;
        this.state = state;
        this.customerID = customerID;
        this.pizzaID = pizzaID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "orderID=" + orderID + ", quantity=" + quantity + ", total=" + total + ", state=" + state + ", customerID=" + customerID + ", pizzaID=" + pizzaID + '}';
    }

}

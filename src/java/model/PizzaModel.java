package model;

public class PizzaModel {

    private int pizzaID;
    private String name;
    private Double price;

    public PizzaModel(int pizzaID, String name, Double price) {
        this.pizzaID = pizzaID;
        this.name = name;
        this.price = price;
    }

    public PizzaModel(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PizzaModel{" + "pizzaID=" + pizzaID + ", name=" + name + ", price=" + price + '}';
    }

}

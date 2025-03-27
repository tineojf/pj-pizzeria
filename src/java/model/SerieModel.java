package model;

public class SerieModel {

    private int serieID;
    private String name;
    private int quantity;

    public SerieModel(int serieID, String name, int quantity) {
        this.serieID = serieID;
        this.name = name;
        this.quantity = quantity;
    }

    public SerieModel(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getSerieID() {
        return serieID;
    }

    public void setSerieID(int serieID) {
        this.serieID = serieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SerieModel{" + "serieID=" + serieID + ", name=" + name + ", quantity=" + quantity + '}';
    }

}

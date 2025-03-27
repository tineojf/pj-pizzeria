package model;

public class CustomerModel {

    private int customerID;
    private String dni;
    private String name;
    private String lastName;

    public CustomerModel(int customerID, String dni, String name, String lastName) {
        this.customerID = customerID;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public CustomerModel(String dni, String name, String lastName) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "customerID=" + customerID + ", dni=" + dni + ", name=" + name + ", lastName=" + lastName + '}';
    }

}

package model;

public class CustomerModel {

    private int customerID;
    private String dni;
    private String fullName;

    public CustomerModel(int customerID, String dni, String fullName) {
        this.customerID = customerID;
        this.dni = dni;
        this.fullName = fullName;
    }

    public CustomerModel(String dni, String fullName) {
        this.dni = dni;
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "customerID=" + customerID + ", dni=" + dni + ", fullName=" + fullName + '}';
    }

}

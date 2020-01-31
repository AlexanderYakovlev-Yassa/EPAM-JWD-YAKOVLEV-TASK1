package by.epam.yakovlev.task.entity;

import java.util.Objects;

public class Customer {

    private int  id;
    private String firstName;
    private String lastName;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (this == o){
            return true;
        }
        if (!(this.getClass() == o.getClass() )){
            return false;
        }

        Customer customer = (Customer) o;

        return getId() == customer.getId() &&
                getFirstName().equals(customer.getFirstName()) &&
                getLastName().equals(customer.getLastName());
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int res = 7;

        res = res * prime + (this.firstName != null ? this.firstName.hashCode() : 0);
        res = res * prime + (this.lastName != null ? this.lastName.hashCode() : 0);
        res = res * prime + id;

        return res;
    }

    @Override
    public String toString() {

        return this.getClass().getName() + " {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

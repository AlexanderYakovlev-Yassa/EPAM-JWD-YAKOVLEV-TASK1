package by.epam.yakovlev.task.entity;

public class Customer {

    private String passportNumber;
    private String firstName;
    private String lastName;

    public Customer(String passportNumber, String firstName, String lastName) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {
    }

    public String getPassportNumber() {
        return passportNumber;
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
        if (this.getClass() != o.getClass() ){
            return false;
        }

        Customer customer = (Customer) o;

        return getPassportNumber().equals(customer.getPassportNumber()) &&
                getFirstName().equals(customer.getFirstName()) &&
                getLastName().equals(customer.getLastName());
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int res = 7;

        res = res * prime + (this.firstName != null ? this.firstName.hashCode() : 0);
        res = res * prime + (this.lastName != null ? this.lastName.hashCode() : 0);
        res = res * prime + (this.passportNumber != null ? this.passportNumber.hashCode() : 0);

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + " {");
        sb.append("passportNumber='").append(passportNumber).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package by.epam.yakovlev.task.entity;

public class SIMCard {

    private int id;
    private Customer customer;
    private int phoneNumber;
    private AbstractTariff tariff;

    public SIMCard() {
    }

    public SIMCard(int id, Customer customer, int phoneNumber, AbstractTariff tariff) {
        this.id = id;
        this.customer = customer;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AbstractTariff getTariff() {
        return tariff;
    }

    public void setTariff(AbstractTariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) return false;

        SIMCard simCard = (SIMCard) o;

        return id == simCard.id &&
                phoneNumber == simCard.phoneNumber &&
                customer.equals(simCard.customer) &&
                tariff.equals(simCard.tariff);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + id;
        res = res * prime + (customer == null ? 0 : customer.hashCode());
        res = res * prime + phoneNumber;
        res = res * prime + (tariff == null ? 0 : tariff.hashCode());

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("id=").append(id);
        sb.append(", customer=").append(customer);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", tariff=").append(tariff);
        sb.append('}');
        return sb.toString();
    }
}

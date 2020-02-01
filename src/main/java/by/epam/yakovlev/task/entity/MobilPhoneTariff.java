package by.epam.yakovlev.task.entity;

public class MobilPhoneTariff extends AbstractTariff {

    private PhoneTariffPart phoneTariffPart;

    public MobilPhoneTariff() {
        super();
        this.phoneTariffPart = new PhoneTariffPart();
    }

    public MobilPhoneTariff(String tariffName, double monthlyFee, PhoneTariffPart phoneTariffPart) {
        super(tariffName, monthlyFee);
        this.phoneTariffPart = phoneTariffPart;
    }

    public PhoneTariffPart getPhoneTariffPart() {
        return phoneTariffPart;
    }

    public void setPhoneTariffPart(PhoneTariffPart phoneTariffPart) {
        this.phoneTariffPart = phoneTariffPart;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o.getClass() == this.getClass())) {
            return false;
        }

        MobilPhoneTariff that = (MobilPhoneTariff) o;

        return super.equals(that) &&
                phoneTariffPart.equals(that.getPhoneTariffPart());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + super.hashCode();
        res = res * prime + phoneTariffPart.hashCode();

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("phoneTariffPart=").append(phoneTariffPart);
        sb.append('}');
        return sb.toString();
    }
}

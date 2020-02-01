package by.epam.yakovlev.task.entity;

public class SmartPhoneTariff extends AbstractTariff {

    private PhoneTariffPart phoneTariffPart;
    private InternetTariffPart internetTariffPart;

    public SmartPhoneTariff() {
        super();
        this.phoneTariffPart = new PhoneTariffPart();
        this.internetTariffPart = new InternetTariffPart();
    }

    public SmartPhoneTariff(String tariffName, double monthlyFee, PhoneTariffPart phoneTariffPart, InternetTariffPart internetTariffPart) {
        super(tariffName, monthlyFee);
        this.phoneTariffPart = phoneTariffPart;
        this.internetTariffPart = internetTariffPart;
    }

    public PhoneTariffPart getPhoneTariffPart() {
        return phoneTariffPart;
    }

    public void setPhoneTariffPart(PhoneTariffPart phoneTariffPart) {
        this.phoneTariffPart = phoneTariffPart;
    }

    public InternetTariffPart getInternetTariffPart() {
        return internetTariffPart;
    }

    public void setInternetTariffPart(InternetTariffPart internetTariffPart) {
        this.internetTariffPart = internetTariffPart;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        SmartPhoneTariff that = (SmartPhoneTariff) o;

        return super.equals(that) &&
                phoneTariffPart.equals(that.phoneTariffPart) &&
                internetTariffPart.equals(that.internetTariffPart);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + super.hashCode();
        res = res * prime + phoneTariffPart.hashCode();
        res = res * prime + internetTariffPart.hashCode();

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("phoneTariffPart=").append(phoneTariffPart);
        sb.append(", internetTariffPart=").append(internetTariffPart);
        sb.append('}');
        return sb.toString();
    }
}

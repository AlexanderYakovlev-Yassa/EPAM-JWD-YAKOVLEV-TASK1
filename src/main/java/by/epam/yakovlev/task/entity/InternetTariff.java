package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

import java.util.Objects;

public class InternetTariff extends AbstractTariff {

    private InternetTariffPart internetTariffPart;

    public InternetTariff() {
        super();
        this.internetTariffPart = new InternetTariffPart();
    }

    public InternetTariff(String tariffName, double monthlyFee, InternetTariffPart internetTariffPart) {
        super(tariffName, monthlyFee);
        this.internetTariffPart = internetTariffPart;
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

        InternetTariff that = (InternetTariff) o;

        return super.equals(that) &&
                internetTariffPart.equals(that.internetTariffPart);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + internetTariffPart.hashCode();
        res = res * prime + super.hashCode();

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("internetTariffPart=").append(internetTariffPart);
        sb.append('}');
        return sb.toString();
    }
}

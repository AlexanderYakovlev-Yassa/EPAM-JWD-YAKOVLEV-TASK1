package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

import java.util.Objects;

public abstract class AbstractTariff {

    private String tariffName;
    private double monthlyFee;

    public AbstractTariff() {
        this.tariffName = StringConstant.NO_NAME.getValue();
        this.monthlyFee = IntConstant.ZERO.getValue();
    }

    public AbstractTariff(String tariffName, double monthlyFee) {

        this.tariffName = tariffName;
        this.monthlyFee = monthlyFee;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
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

        AbstractTariff that = (AbstractTariff) o;

        return (int)(that.monthlyFee * IntConstant.MAX_CURRENCY_DIVIDER.getValue()) ==
                (int)(monthlyFee * IntConstant.MAX_CURRENCY_DIVIDER.getValue()) &&
                tariffName.equals(that.tariffName);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (tariffName == null ? 0 : tariffName.hashCode());
        res = res * prime + (int)(monthlyFee * IntConstant.MAX_CURRENCY_DIVIDER.getValue());

        return res;
    }
}

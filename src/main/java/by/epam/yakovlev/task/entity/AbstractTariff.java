package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.StringConstant;

import java.math.BigDecimal;

public abstract class AbstractTariff {

    protected String tariffName;
    protected BigDecimal monthlyFee;

    public AbstractTariff() {
    }

    public AbstractTariff(String tariffName, BigDecimal monthlyFee) {

        this.tariffName = tariffName;
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

        return monthlyFee.compareTo(that.monthlyFee) == 0 &&
                tariffName.equals(that.tariffName);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (tariffName == null ? 0 : tariffName.hashCode());
        res = res * prime + (monthlyFee == null ? 0 : monthlyFee.hashCode());

        return res;
    }
}

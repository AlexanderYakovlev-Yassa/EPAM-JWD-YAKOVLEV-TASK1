package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractTariff {

    private String tariffName;
    private BigDecimal monthlyFee;

    public AbstractTariff() {
        this.tariffName = StringConstant.NO_NAME.getValue();
        this.monthlyFee = BigDecimal.valueOf(0.0);
    }

    public AbstractTariff(String tariffName, BigDecimal monthlyFee) {

        this.tariffName = tariffName;
        this.monthlyFee = monthlyFee;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
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

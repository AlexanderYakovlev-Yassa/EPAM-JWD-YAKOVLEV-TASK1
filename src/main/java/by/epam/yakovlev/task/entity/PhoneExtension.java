package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

import java.io.Serializable;
import java.math.BigDecimal;

public class PhoneExtension implements Serializable, TariffExtension{

    private String phoneExtensionName;
    private BigDecimal incomeCallFee;
    private BigDecimal outcomeCallFee;
    private int innerProviderIncludedMinutes;
    private int anyProviderIncludedMinutes;

    public PhoneExtension() {
        phoneExtensionName = StringConstant.NO_NAME.getValue();
    }

    public PhoneExtension(String phoneExtensionName,
                          BigDecimal incomeCallFee,
                          BigDecimal outcomeCallFee,
                          int innerProviderIncludedMinutes,
                          int anyProviderIncludedMinutes) {
        this.phoneExtensionName = phoneExtensionName;
        this.incomeCallFee = incomeCallFee;
        this.outcomeCallFee = outcomeCallFee;
        this.innerProviderIncludedMinutes = innerProviderIncludedMinutes;
        this.anyProviderIncludedMinutes = anyProviderIncludedMinutes;
    }

    public String getPhoneExtensionName() {
        return phoneExtensionName;
    }

    public void setPhoneExtensionName(String phoneExtensionName) {
        this.phoneExtensionName = phoneExtensionName;
    }

    public BigDecimal getIncomeCallFee() {
        return incomeCallFee;
    }

    public void setIncomeCallFee(BigDecimal incomeCallFee) {
        this.incomeCallFee = incomeCallFee;
    }

    public BigDecimal getOutcomeCallFee() {
        return outcomeCallFee;
    }

    public void setOutcomeCallFee(BigDecimal outcomeCallFee) {
        this.outcomeCallFee = outcomeCallFee;
    }

    public int getInnerProviderIncludedMinutes() {
        return innerProviderIncludedMinutes;
    }

    public void setInnerProviderIncludedMinutes(int innerProviderIncludedMinutes) {
        this.innerProviderIncludedMinutes = innerProviderIncludedMinutes;
    }

    public int getAnyProviderIncludedMinutes() {
        return anyProviderIncludedMinutes;
    }

    public void setAnyProviderIncludedMinutes(int anyProviderIncludedMinutes) {
        this.anyProviderIncludedMinutes = anyProviderIncludedMinutes;
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
        PhoneExtension that = (PhoneExtension) o;
        return phoneExtensionName.equals(that.phoneExtensionName) &&
                incomeCallFee.equals(that.incomeCallFee) &&
                outcomeCallFee.equals(that.outcomeCallFee) &&
                this.innerProviderIncludedMinutes == that.innerProviderIncludedMinutes &&
                this.anyProviderIncludedMinutes == that.anyProviderIncludedMinutes;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (this.phoneExtensionName != null ? this.phoneExtensionName.hashCode() : 0);
        res = res * prime + (incomeCallFee != null ? incomeCallFee.hashCode() : 0);
        res = res * prime + (outcomeCallFee != null ? outcomeCallFee.hashCode() : 0);
        res = res * prime + innerProviderIncludedMinutes;
        res = res * prime + anyProviderIncludedMinutes;

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("phoneExtensionName='").append(phoneExtensionName).append('\'');
        sb.append(", incomeCallFee=").append(incomeCallFee);
        sb.append(", outcomeCallFee=").append(outcomeCallFee);
        sb.append(", innerProviderIncludedMinutes=").append(innerProviderIncludedMinutes);
        sb.append(", anyProviderIncludedMinutes=").append(anyProviderIncludedMinutes);
        sb.append('}');
        return sb.toString();
    }

    private int normalizeCost(double cost) {
        return (int) (cost * IntConstant.MAX_CURRENCY_DIVIDER.getValue());
    }
}

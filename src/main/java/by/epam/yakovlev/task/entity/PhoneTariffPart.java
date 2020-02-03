package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

public class PhoneTariffPart {

    private String phoneTariffPartName;
    private double incomeCallFee;
    private double outcomeCallFee;
    private int innerProviderIncludedMinutes;
    private int anyProviderIncludedMinutes;

    public PhoneTariffPart() {
        phoneTariffPartName = StringConstant.NO_NAME.getValue();
    }

    public PhoneTariffPart(String phoneTariffPartName,
                           double incomeCallFee,
                           double outcomeCallFee,
                           int innerProviderIncludedMinutes,
                           int anyProviderIncludedMinutes) {
        this.phoneTariffPartName = phoneTariffPartName;
        this.incomeCallFee = incomeCallFee;
        this.outcomeCallFee = outcomeCallFee;
        this.innerProviderIncludedMinutes = innerProviderIncludedMinutes;
        this.anyProviderIncludedMinutes = anyProviderIncludedMinutes;
    }

    public String getPhoneTariffPartName() {
        return phoneTariffPartName;
    }

    public void setPhoneTariffPartName(String phoneTariffPartName) {
        this.phoneTariffPartName = phoneTariffPartName;
    }

    public double getIncomeCallFee() {
        return incomeCallFee;
    }

    public void setIncomeCallFee(double incomeCallFee) {
        this.incomeCallFee = incomeCallFee;
    }

    public double getOutcomeCallFee() {
        return outcomeCallFee;
    }

    public void setOutcomeCallFee(double outcomeCallFee) {
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
        PhoneTariffPart that = (PhoneTariffPart) o;
        return phoneTariffPartName.equals(that.phoneTariffPartName) &&
                normalizeCost(incomeCallFee) == normalizeCost(that.incomeCallFee) &&
                normalizeCost(outcomeCallFee) == normalizeCost(that.outcomeCallFee) &&
                this.innerProviderIncludedMinutes == that.innerProviderIncludedMinutes &&
                this.anyProviderIncludedMinutes == that.anyProviderIncludedMinutes;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (this.phoneTariffPartName != null ? this.phoneTariffPartName.hashCode() : 0);
        res = res * prime + normalizeCost(incomeCallFee);
        res = res * prime + normalizeCost(outcomeCallFee);
        res = res * prime + innerProviderIncludedMinutes;
        res = res * prime + anyProviderIncludedMinutes;

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("phoneTariffPartName='").append(phoneTariffPartName).append('\'');
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

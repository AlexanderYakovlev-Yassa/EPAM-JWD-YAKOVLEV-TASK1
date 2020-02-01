package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

public class PhoneTariffPart {

    private String phoneTariffPartName;
    private double incomeCallFee;
    private double outcomeCallFee;

    public PhoneTariffPart() {
        phoneTariffPartName = StringConstant.NO_NAME.getValue();
    }

    public PhoneTariffPart(String phoneTariffPartName, double incomeCallFee, double outcomeCallFee) {
        this.phoneTariffPartName = phoneTariffPartName;
        this.incomeCallFee = incomeCallFee;
        this.outcomeCallFee = outcomeCallFee;
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

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return  false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        PhoneTariffPart that = (PhoneTariffPart) o;
        return Double.compare(that.incomeCallFee, incomeCallFee) == 0 &&
                Double.compare(that.outcomeCallFee, outcomeCallFee) == 0 &&
                phoneTariffPartName.equals(that.phoneTariffPartName);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (this.phoneTariffPartName != null ? this.phoneTariffPartName.hashCode() : 0);
        res = res * prime + (int)(this.incomeCallFee * IntConstant.MAX_CURRENCY_DIVIDER.getValue());
        res = res * prime + (int)(this.outcomeCallFee * IntConstant.MAX_CURRENCY_DIVIDER.getValue());

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("phoneTariffPartName='").append(phoneTariffPartName).append('\'');
        sb.append(", incomeCallFee=").append(incomeCallFee);
        sb.append(", outcomeCallFee=").append(outcomeCallFee);
        sb.append('}');

        return sb.toString();
    }
}

package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

import java.util.Objects;

/**
 * Represents the part of a tariff that responsible for internet
 */
public class InternetTariffPart {

    private String internetTariffPartName;
    /**
     * The measure unit of traffic limit is bite
     * -1 mean unlimited traffic
     */
    private int trafficLimit;
    /**
     * The measure unit of traffic speed limit is Byte per second
     * -1 mean unlimited speed
     */
    private int trafficSpeedLimit;
    /**
     * The measure unit of traffic fee is BYN per 1 048 576 Byte
     */
    private double trafficFee;
    private int includedTraffic;

    public InternetTariffPart() {
        this.internetTariffPartName = StringConstant.NO_NAME.getValue();
        this.trafficFee = 0;
        this.trafficLimit = -1;
        this.trafficSpeedLimit = -1;
        this.includedTraffic = 0;
    }

    public InternetTariffPart(String internetTariffPartName,
                              int trafficLimit,
                              int trafficSpeedLimit,
                              double trafficFee,
                              int includedTraffic) {
        this.internetTariffPartName = internetTariffPartName;
        this.trafficLimit = trafficLimit;
        this.trafficSpeedLimit = trafficSpeedLimit;
        this.trafficFee = trafficFee;
        this.includedTraffic = includedTraffic;
    }

    public String getInternetTariffPartName() {
        return internetTariffPartName;
    }

    public void setInternetTariffPartName(String internetTariffPartName) {
        this.internetTariffPartName = internetTariffPartName;
    }

    public int getTrafficLimit() {
        return trafficLimit;
    }

    public void setTrafficLimit(int trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    public int getTrafficSpeedLimit() {
        return trafficSpeedLimit;
    }

    public void setTrafficSpeedLimit(int trafficSpeedLimit) {
        this.trafficSpeedLimit = trafficSpeedLimit;
    }

    public double getTrafficFee() {
        return trafficFee;
    }

    public void setTrafficFee(double trafficFee) {
        this.trafficFee = trafficFee;
    }

    public int getIncludedTraffic() {
        return includedTraffic;
    }

    public void setIncludedTraffic(int includedTraffic) {
        this.includedTraffic = includedTraffic;
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

        InternetTariffPart that = (InternetTariffPart) o;

        return internetTariffPartName.equals(that.internetTariffPartName) &&
                trafficLimit == that.trafficLimit &&
                trafficSpeedLimit == that.trafficSpeedLimit &&
                normalizeCost(trafficFee) == normalizeCost(that.trafficFee) &&
                includedTraffic == that.includedTraffic;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (this.internetTariffPartName != null ? this.internetTariffPartName.hashCode() : 0);
        res = res * prime + trafficLimit;
        res = res * prime + trafficSpeedLimit;
        res = res * prime + normalizeCost(trafficFee);
        res = res * prime + includedTraffic;

        return res;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("internetTariffPartName='").append(internetTariffPartName).append('\'');
        sb.append(", trafficLimit=").append(trafficLimit);
        sb.append(", trafficSpeedLimit=").append(trafficSpeedLimit);
        sb.append(", trafficFee=").append(trafficFee);
        sb.append('}');

        return sb.toString();
    }

    private int normalizeCost(double cost){
        return (int)(cost * IntConstant.MAX_CURRENCY_DIVIDER.getValue());
    }
}

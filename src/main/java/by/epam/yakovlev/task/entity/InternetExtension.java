package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.IntConstant;
import by.epam.yakovlev.task.StringConstant;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Represents the part of a tariff that responsible for internet
 */
public class InternetExtension implements Serializable, TariffExtension, ApplicationCompatibleType{

    private String internetExtensionName;

    private double includedTraffic;

    /**
     * The measure unit of traffic limit is GB
     * -1 mean unlimited traffic
     */
    private double trafficLimit;

    /**
     * The measure unit of traffic speed limit is Mbps
     * -1 mean unlimited speed
     */
    private double trafficSpeedLimit;

    /**
     * The measure unit of traffic fee is BYN / MB
     */
    private BigDecimal trafficFee;

    public InternetExtension() {
        this.internetExtensionName = StringConstant.NO_NAME.getValue();
        this.trafficFee = BigDecimal.valueOf(0.0);
        this.trafficLimit = -1;
        this.trafficSpeedLimit = -1;
        this.includedTraffic = 0;
    }

    public InternetExtension(String internetExtensionName, double includedTraffic, double trafficLimit, double trafficSpeedLimit, BigDecimal trafficFee) {
        this.internetExtensionName = internetExtensionName;
        this.includedTraffic = includedTraffic;
        this.trafficLimit = trafficLimit;
        this.trafficSpeedLimit = trafficSpeedLimit;
        this.trafficFee = trafficFee;
    }

    public String getInternetExtensionName() {
        return internetExtensionName;
    }

    public void setInternetExtensionName(String internetExtensionName) {
        this.internetExtensionName = internetExtensionName;
    }

    public double getTrafficLimit() {
        return trafficLimit;
    }

    public void setTrafficLimit(double trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    public double getTrafficSpeedLimit() {
        return trafficSpeedLimit;
    }

    public void setTrafficSpeedLimit(double trafficSpeedLimit) {
        this.trafficSpeedLimit = trafficSpeedLimit;
    }

    public BigDecimal getTrafficFee() {
        return trafficFee;
    }

    public void setTrafficFee(BigDecimal trafficFee) {
        this.trafficFee = trafficFee;
    }

    public double getIncludedTraffic() {
        return includedTraffic;
    }

    public void setIncludedTraffic(double includedTraffic) {
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

        InternetExtension that = (InternetExtension) o;

        return internetExtensionName.equals(that.internetExtensionName) &&
                includedTraffic == that.includedTraffic &&
                trafficLimit == that.trafficLimit &&
                trafficSpeedLimit == that.trafficSpeedLimit &&
                trafficFee.compareTo(that.trafficFee) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (this.internetExtensionName != null ? this.internetExtensionName.hashCode() : 0);
        res = res * prime + Double.hashCode(includedTraffic);
        res = res * prime + Double.hashCode(trafficLimit);
        res = res * prime + Double.hashCode(trafficSpeedLimit);
        res = res * prime + (trafficFee != null ? trafficFee.hashCode() : 0);

        return res;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder(getClass().getName() + "{");
        sb.append("internetExtensionName='").append(internetExtensionName).append('\'');
        sb.append(", includedTraffic=").append(includedTraffic);
        sb.append(", trafficLimit=").append(trafficLimit);
        sb.append(", trafficSpeedLimit=").append(trafficSpeedLimit);
        sb.append(", trafficFee=").append(trafficFee);
        sb.append('}');

        return sb.toString();
    }
}

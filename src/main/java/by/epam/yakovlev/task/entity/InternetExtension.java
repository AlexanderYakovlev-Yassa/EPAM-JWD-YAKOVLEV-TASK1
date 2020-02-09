package by.epam.yakovlev.task.entity;

import by.epam.yakovlev.task.StringConstant;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Represents the part of a tariff that responsible for internet
 */
public class InternetExtension implements Serializable, TariffExtension, RepositoryCompatibleType {

    private String internetExtensionName;

    private Double includedTraffic;

    /**
     * The measure unit of traffic limit is GB
     * -1 mean unlimited traffic
     */
    private Double trafficLimit;

    /**
     * The measure unit of traffic speed limit is Mbps
     * -1 mean unlimited speed
     */
    private Double trafficSpeedLimit;

    /**
     * The measure unit of traffic fee is BYN / MB
     */
    private BigDecimal trafficFee;

    public InternetExtension() {
    }

    public InternetExtension(String internetExtensionName, Double includedTraffic, Double trafficLimit, Double trafficSpeedLimit, BigDecimal trafficFee) {
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

    public Double getTrafficLimit() {
        return trafficLimit;
    }

    public void setTrafficLimit(Double trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    public Double getTrafficSpeedLimit() {
        return trafficSpeedLimit;
    }

    public void setTrafficSpeedLimit(Double trafficSpeedLimit) {
        this.trafficSpeedLimit = trafficSpeedLimit;
    }

    public BigDecimal getTrafficFee() {
        return trafficFee;
    }

    public void setTrafficFee(BigDecimal trafficFee) {
        this.trafficFee = trafficFee;
    }

    public Double getIncludedTraffic() {
        return includedTraffic;
    }

    public void setIncludedTraffic(Double includedTraffic) {
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
                includedTraffic.compareTo(that.includedTraffic) == 0 &&
                trafficLimit.compareTo(that.trafficLimit) == 0 &&
                trafficSpeedLimit.compareTo(that.trafficSpeedLimit) == 0 &&
                trafficFee.compareTo(that.trafficFee) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + (internetExtensionName != null ? internetExtensionName.hashCode() : 0);
        res = res * prime + (includedTraffic != null ? Double.hashCode(includedTraffic) : 0);
        res = res * prime + (trafficLimit != null ? Double.hashCode(trafficLimit) : 0);
        res = res * prime + (trafficSpeedLimit != null ? Double.hashCode(trafficSpeedLimit) : 0);
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

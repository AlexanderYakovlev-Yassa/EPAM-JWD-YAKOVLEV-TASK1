package by.epam.yakovlev.task.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;

public class Tariff extends AbstractTariff implements Serializable, MobilProviderCompatibleType {

    private HashSet<TariffExtension> extensionSet;

    public Tariff() {
        super();
    }

    public Tariff(String tariffName, BigDecimal monthlyFee, HashSet<TariffExtension> extensionSet) {
        super(tariffName, monthlyFee);
        this.extensionSet = extensionSet;
    }

    public HashSet<TariffExtension> getExtensionSet() {
        return extensionSet;
    }

    public void setExtensionSet(HashSet<TariffExtension> extensionSet) {
        this.extensionSet = extensionSet;
    }

    public String getTariffName(){
        return super.tariffName;
    }

    public void setTariffName(String name){
        super.tariffName = name;
    }

    public BigDecimal getMonthlyFee(){
        return super.monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee){
        super.monthlyFee = monthlyFee;
    }

    public boolean addExtension(TariffExtension extension){

        if (extension != null){
            return extensionSet.add(extension);
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o.getClass() != getClass()) {
            return false;
        }

        Tariff that = (Tariff) o;

        if (this.extensionSet.size() != that.extensionSet.size()){
            return false;
        }

        /*for (TariffExtension t : extensionSet) {
            System.out.println(" this " + t.toString());
        }
        for (TariffExtension t : that.extensionSet) {
            System.out.println(" that " + t.toString());
        }*/

        return extensionSet.equals(that.extensionSet) ;
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int res = 7;

        res = res * prime + (tariffName == null ? 0 : tariffName.hashCode());
        res = res * prime + (monthlyFee == null ? 0 : tariffName.hashCode());

        if (extensionSet != null) {
            for (TariffExtension ext : extensionSet) {
                res = res * prime + (ext == null ? 0 : ext.hashCode());
            }
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName() + "{");

        for (TariffExtension ext : extensionSet){
            sb.append(ext.toString() + ", ");
        }

        sb.append("\b\b}");
        
        return sb.toString();
    }
}

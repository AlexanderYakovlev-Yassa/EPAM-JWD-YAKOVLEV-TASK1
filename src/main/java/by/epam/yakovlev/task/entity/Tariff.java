package by.epam.yakovlev.task.entity;

import java.io.Serializable;
import java.util.HashSet;

public class Tariff extends AbstractTariff implements Serializable {

    private HashSet<TariffExtension> extensionSet;

    public Tariff() {
        super();
    }

    public Tariff(String tariffName, double monthlyFee, HashSet<TariffExtension> extensionSet) {
        super(tariffName, monthlyFee);
        this.extensionSet = extensionSet;
    }

    public HashSet<TariffExtension> getExtensionSet() {
        return extensionSet;
    }

    public void setExtensionSet(HashSet<TariffExtension> extensionSet) {
        this.extensionSet = extensionSet;
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

        Tariff tariff = (Tariff) o;

        return extensionSet.equals(tariff.extensionSet);
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int res = 7;

        for (TariffExtension ext : extensionSet){
            res = res * prime + ext.hashCode();
        }

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName() + "{");

        for (TariffExtension ext : extensionSet){
            sb.append(ext.toString() + ", ");
        }

        sb.append("\b\b}");
        
        return sb.toString();
    }
}

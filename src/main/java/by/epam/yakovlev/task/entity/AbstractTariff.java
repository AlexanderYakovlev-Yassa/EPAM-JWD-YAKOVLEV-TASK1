package by.epam.yakovlev.task.entity;

public abstract class AbstractTariff {

    private String tariffName;
    private double monthlyFee;

    public AbstractTariff(String tariffName, double monthlyFee) {

        this.tariffName = tariffName;
        this.monthlyFee = monthlyFee;
    }


}

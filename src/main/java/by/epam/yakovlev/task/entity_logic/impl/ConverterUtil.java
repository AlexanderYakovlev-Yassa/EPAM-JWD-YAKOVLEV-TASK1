package by.epam.yakovlev.task.entity_logic.impl;

import java.math.BigDecimal;

public enum  ConverterUtil {

    INSTANCE;

    public Double stringToPositiveDouble(String string) {

        Double d;

        try {
            d = Double.parseDouble(string);
        } catch (NumberFormatException e){
            return null;
        }

        if (d < 0){
            return null;
        }

        return d;
    }

    public Integer stringToPositiveInt(String string){

        Integer d;

        try {
            d = Integer.parseInt(string);
        } catch (NumberFormatException e){
            return null;
        }

        if (d < 0){
            return null;
        }

        return d;
    }

    public BigDecimal stringToPositiveBigDecimal(String string) {

        BigDecimal b = null;

        try {
            b = BigDecimal.valueOf(Double.parseDouble(string));
        } catch (NumberFormatException e){
            return null;
        }

        if (b.compareTo(BigDecimal.valueOf(0.0)) < 0){
            return null;
        }

        return b;
    }
}

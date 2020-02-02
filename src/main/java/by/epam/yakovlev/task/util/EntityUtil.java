package by.epam.yakovlev.task.util;

import by.epam.yakovlev.task.exception.EntityMakingException;

public enum EntityUtil {

    INSTANCE;

    //name 10.00 phone_part_name internet_part_name
    //name income_call_fee outcome_call_fee
    //name traffic_limit traffic_speed_limit traffic_fee


    public double stringToPositiveDouble(String string) throws EntityMakingException {

        double d;

        try {
            d = Double.parseDouble(string);
        } catch (NumberFormatException e){
            throw new EntityMakingException("Fail conversion to double", e);
        }

        if (d < 0){
            throw new EntityMakingException("Negative value");
        }

        return d;
    }

    public int stringToPositiveInt(String string) throws EntityMakingException {

        int d;

        try {
            d = Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new EntityMakingException("Fail conversion to int", e);
        }

        if (d < 0){
            throw new EntityMakingException("Negative value");
        }

        return d;
    }
}

package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.StringConstant;
import by.epam.yakovlev.task.entity.*;
import by.epam.yakovlev.task.exception.EntityMakingException;
import by.epam.yakovlev.task.entity_logic.EntityLogic;
import by.epam.yakovlev.task.util.EntityUtil;

import java.util.Optional;

public enum  EntityLogicImpl implements EntityLogic {

    INSTANCE;

    private static EntityUtil util = EntityUtil.INSTANCE;

    @Override
    public Optional<AbstractTariff> getTariff(String tariffName,
                                              Double monthlyFee,
                                              Optional<PhoneTariffPart> phoneTariffPart,
                                              Optional<InternetTariffPart> internetTariffPart)
            throws EntityMakingException {

        /*if (tariffName == null || tariffName.equals(StringConstant.EMPTY_STRING.getValue())){
            throw new ServiceEntityFactoryException("Null or empty tariff name");
        }
        if (monthlyFee < 0){
            throw new ServiceEntityFactoryException("Negative monthly fee");
        }*/

        AbstractTariff tariff = null;

        /*if (phoneTariffPart != null && internetTariffPart != null){
            tariff = new SmartPhoneTariff(tariffName, monthlyFee, phoneTariffPart, internetTariffPart);
        }*/


        return Optional.empty();
    }

    @Override
    public Optional<Customer> getCustomer(String firstName, String lastName, String passport) {
        return Optional.empty();
    }

    @Override
    public PhoneTariffPart makePhoneTariffPart(String string) throws EntityMakingException {

        final int fieldNumber = 3;
        final int maxNameLength = 255;

        if (string == null) {
            throw new EntityMakingException("The NULL parameter string");
        }

        PhoneTariffPart res = null;

        String[] fields = string.trim().split(StringConstant.FIELD_DELIMITER.getValue());

        if (fields.length < fieldNumber){
            throw new EntityMakingException("The parameter string is wrong");
        }
        if (fields[0].length() > maxNameLength) {
            throw new EntityMakingException("The name of the internet tariff part is too long");
        }

        String name = fields[0];
        double incomeCallFee = util.stringToPositiveDouble(fields[1]);
        double outcomeCallFee = util.stringToPositiveDouble(fields[2]);

        PhoneTariffPart phoneTariffPart = new PhoneTariffPart(
                name, incomeCallFee, outcomeCallFee);

        res = phoneTariffPart;

        return res;
    }

    @Override
    public InternetTariffPart makeInternetTariffPart(String string) throws EntityMakingException {
        final int fieldNumber = 4;
        final int maxNameLength = 255;

        if (string == null) {
            throw new EntityMakingException("The NULL parameter string");
        }

        InternetTariffPart res = null;

        String[] fields = string.trim().split(StringConstant.FIELD_DELIMITER.getValue());

        if (fields.length < fieldNumber){
            throw new EntityMakingException("The parameter string is wrong");
        }
        if (fields[0].length() > maxNameLength) {
            throw new EntityMakingException("The name of the internet tariff part is too long");
        }

        String name = fields[0];
        int trafficLimit = util.stringToPositiveInt(fields[1]);
        int trafficSpeedLimit = util.stringToPositiveInt(fields[2]);
        double trafficFee = util.stringToPositiveDouble(fields[3]);

        InternetTariffPart internetTariffPart = new InternetTariffPart(
                name, trafficLimit, trafficSpeedLimit, trafficFee);

        res = internetTariffPart;

        return res;
    }
}

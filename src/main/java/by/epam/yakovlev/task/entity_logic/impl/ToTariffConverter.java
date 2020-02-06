package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.StringConstant;
import by.epam.yakovlev.task.entity.Tariff;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.repository.Repository;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class ToTariffConverter {

    private static final Logger LOGGER = Logger.getLogger(ToTariffConverter.class);

    private final static ConverterUtil UTIL = ConverterUtil.getINSTANCE();
    private final static Factory FACTORY = Factory.getInstance();
    private final static Repository REPOSITORY = FACTORY.getRepository();

    public Tariff convertToTariff(String string) {

        if (string == null) {
            LOGGER.info("Can't create tariff from null string");
            return null;
        }

        Tariff tariff = new Tariff();

        String[] fields = string.trim().split(StringConstant.FIELD_DELIMITER.getValue());

        if (fields.length < 3) {
            LOGGER.info("It's lack of fields in string [" + string + "].");
            return null;
        }

        String name = fields[0];
        BigDecimal monthlyFee = UTIL.stringToPositiveBigDecimal(fields[1]);

        if (monthlyFee == null) {
            LOGGER.info("Can't convert the field [" + fields[1] + "] to monthly fee.");
            return null;
        }

        tariff.setTariffName(name);

        tariff.setMonthlyFee(monthlyFee);

        String typeName;
        String extensionName;
        TariffExtension tempTariffExtension = null;

        for (int i = 2; i < fields.length; i++) {

            String[] param = fields[i].split(StringConstant.ATTRIBUTE_DELIMITER.getValue());
            typeName = param[0];
            extensionName = param[1];

            tempTariffExtension = REPOSITORY.findExtensionByTypeAndName(typeName, extensionName);

            if (tempTariffExtension == null){
                LOGGER.info("There is no extension with type [" + typeName.toUpperCase() + "] and name [" +
                        extensionName + "].");
            } else {
                tariff.addExtension(tempTariffExtension);
            }
        }

        return tariff;
    }
}

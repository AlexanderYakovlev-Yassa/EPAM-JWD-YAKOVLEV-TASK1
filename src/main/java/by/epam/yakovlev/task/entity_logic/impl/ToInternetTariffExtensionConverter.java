package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.StringConstant;
import by.epam.yakovlev.task.entity.InternetExtension;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.entity_logic.ExtensionConverter;

import java.math.BigDecimal;

public class ToInternetTariffExtensionConverter implements ExtensionConverter {

    private final static ConverterUtil UTIL = ConverterUtil.getINSTANCE();

    @Override
    public TariffExtension convertToTariffExtension(String string) {

        if (string == null) {
            return null;
        }

        final int FIELD_NUMBER = 5;
        final int MAX_NAME_LENGTH = 255;

        String[] fields = string.split(StringConstant.FIELD_DELIMITER.getValue());

        if (fields.length != FIELD_NUMBER) {
            return null;
        }

        boolean successFlag = true;

        String name = null;
        Double includedTraffic = null;
        Double trafficLimit = null;
        Double trafficSpeedLimit = null;
        BigDecimal trafficFee = null;

        successFlag = (name = fields[0]).length() > 0 && name.length() <= MAX_NAME_LENGTH;
        successFlag = successFlag && (includedTraffic = UTIL.stringToPositiveDouble(fields[1])) != null;
        successFlag = successFlag && (trafficLimit = UTIL.stringToPositiveDouble(fields[2])) != null;
        successFlag = successFlag && (trafficSpeedLimit = UTIL.stringToPositiveDouble(fields[3])) != null;
        successFlag = successFlag && (trafficFee = UTIL.stringToPositiveBigDecimal(fields[4])) != null;

        if (!successFlag) {
            return null;
        }

        TariffExtension res = new InternetExtension(name,
                includedTraffic,
                trafficLimit,
                trafficSpeedLimit,
                trafficFee);

        return res;
    }
}

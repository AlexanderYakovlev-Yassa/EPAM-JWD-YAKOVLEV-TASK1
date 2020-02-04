package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.StringConstant;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.entity_logic.ExtensionConverter;

import java.math.BigDecimal;

public class ToPhoneTariffExtensionConverter implements ExtensionConverter {

    private final static ConverterUtil UTIL = ConverterUtil.INSTANCE;

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
        BigDecimal incomeCallFee = null;
        BigDecimal outcomeCallFee = null;
        Integer innerProviderIncludedMinutes = null;
        Integer anyProviderIncludedMinutes = null;

        successFlag = (name = fields[0]).length() > 0 && name.length() <= MAX_NAME_LENGTH;
        successFlag = successFlag && (incomeCallFee = UTIL.stringToPositiveBigDecimal(fields[1])) != null;
        successFlag = successFlag && (outcomeCallFee = UTIL.stringToPositiveBigDecimal(fields[2])) != null;
        successFlag = successFlag && (innerProviderIncludedMinutes = UTIL.stringToPositiveInt(fields[3])) != null;
        successFlag = successFlag && (anyProviderIncludedMinutes = UTIL.stringToPositiveInt(fields[4])) != null;

        if (!successFlag) {
            return null;
        }

        PhoneExtension res = new PhoneExtension(name,
                incomeCallFee,
                outcomeCallFee,
                innerProviderIncludedMinutes,
                anyProviderIncludedMinutes);

        return res;
    }
}

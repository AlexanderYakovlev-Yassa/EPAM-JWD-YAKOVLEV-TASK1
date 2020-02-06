package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.StringConstant;
import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.jar.Attributes;

public class   ConverterUtil {

    private static final ConverterUtil INSTANCE = new ConverterUtil();

    private static Logger LOGGER = Logger.getLogger(ConverterUtil.class);

    private ConverterUtil(){}

    public static ConverterUtil getInstance() {
        return INSTANCE;
    }

    public Double stringToPositiveDouble(String string) {

        if(string == null){
            return null;
        }

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

        if (string == null) {
            return null;
        }

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

    public Attributes ParseStringToAttributes(String string){

        if (string == null){
            return null;
        }

        Attributes attributes = new Attributes();

        String[] fieldArray = string.trim().split(StringConstant.FIELD_DELIMITER.getValue());

        String[] tempAttributeFields = null;
        for (String s : fieldArray){

            tempAttributeFields = s.split(StringConstant.ATTRIBUTE_DELIMITER.getValue());

            if (tempAttributeFields.length >= 2){

                try {
                    attributes.putValue(tempAttributeFields[0], tempAttributeFields[1]);
                } catch (IllegalArgumentException e){
                    LOGGER.debug("Wrong attribute fields in string [" + s + "].");
                }
            }
        }

        return attributes;
    }
}

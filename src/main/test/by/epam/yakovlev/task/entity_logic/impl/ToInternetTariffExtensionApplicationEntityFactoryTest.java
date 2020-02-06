package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.entity.InternetExtension;
import by.epam.yakovlev.task.entity.TariffExtension;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ToInternetTariffExtensionApplicationEntityFactoryTest {

    private static final ConverterUtil UTIL = ConverterUtil.getInstance();
    private static final ToInternetTariffExtensionConverter CONVERTER = new ToInternetTariffExtensionConverter();


    @Test
    public void convertToTariffExtensionPositiveTest() {

        String string = "basic        0.1   0.5     2       0.003";

        InternetExtension excepted = new InternetExtension("basic",
                0.1 ,
                0.5,
                2,
                BigDecimal.valueOf(0.003));

        TariffExtension actual = CONVERTER.convertToTariffExtension(string);

        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void convertToTariffExtensionNegativeTest() {

        String string = "basic        0   0.1     s       50";

        TariffExtension actual = CONVERTER.convertToTariffExtension(string);

        Assert.assertNull(actual);

        string = "";

        Assert.assertNull(actual);

        string = null;

        Assert.assertNull(actual);
    }
}
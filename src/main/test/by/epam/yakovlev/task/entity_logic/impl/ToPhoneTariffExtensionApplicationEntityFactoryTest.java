package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.entity.TariffExtension;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ToPhoneTariffExtensionApplicationEntityFactoryTest {

    private static final ConverterUtil UTIL = ConverterUtil.getInstance();
    private static final ToPhoneTariffExtensionConverter CONVERTER = new ToPhoneTariffExtensionConverter();

    @Test
    public void convertToTariffExtensionPositiveTest() {

        String string = "basic        0   0.1     100       50";

        PhoneExtension excepted = new PhoneExtension("basic",
                BigDecimal.valueOf(0.0) ,
                BigDecimal.valueOf(0.1),
                100,
                50);

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
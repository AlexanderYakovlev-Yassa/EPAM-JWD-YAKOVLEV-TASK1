package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.entity.ApplicationCompatibleType;
import by.epam.yakovlev.task.entity.EntityTypeEnum;
import by.epam.yakovlev.task.entity.InternetExtension;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.entity_logic.ApplicationEntityFactory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ApplicationEntityFactoryImplTest {

    private static final ConverterUtil UTIL = ConverterUtil.getInstance();

    private static final Factory FACTORY = Factory.getInstance();
    private static final ApplicationEntityFactory ENTITY_FACTORY = FACTORY.getApplicationEntityFactory();

    @Test
    public void applicationEntityFactoryPositiveTest() {

        String string = "name=elite       income-call-fee=0  outcome-call-fee=0.2     " +
                "inner-provider-included-minutes=1000    any-provider-included-minutes=2000";

        ApplicationCompatibleType concreteEntity = ENTITY_FACTORY.applicationEntityFactory(string, EntityTypeEnum.TARIFF_PHONE_EXTENSION);

        Assert.assertNotNull(concreteEntity);

        PhoneExtension excepted = new PhoneExtension("elite",
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(0.2),
                1000,
                2000);

        PhoneExtension actual = (PhoneExtension) concreteEntity;

        Assert.assertEquals(excepted, actual);


    }
}
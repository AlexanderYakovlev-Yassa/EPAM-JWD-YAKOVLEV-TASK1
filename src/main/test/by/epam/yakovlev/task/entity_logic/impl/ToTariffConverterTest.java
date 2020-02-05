package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.entity.Tariff;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.impl.RepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToTariffConverterTest {

    private static final Factory FACTORY = Factory.getInstance();
    private static final DAOLogic DAO_LOGIC = FACTORY.getDAOLogic();
    private static final ToTariffConverter CONVERTER = new ToTariffConverter();
    private static final Repository REPOSITORY = FACTORY.getRepository();

    @Test
    public void convertToTariffTest() {

        String string = "long-talk       12.0    phone=long-talk     internet=start";

        Tariff tariff = CONVERTER.convertToTariff(string);

        Assert.assertNotNull(tariff);


    }
}
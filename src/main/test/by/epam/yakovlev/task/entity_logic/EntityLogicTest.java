package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.entity.InternetTariffPart;
import by.epam.yakovlev.task.exception.EntityMakingException;
import org.junit.Assert;
import org.junit.Test;

public class EntityLogicTest {

    private static EntityLogic logic = Factory.INSTANCE.getEntityLogic();

    @Test
    public void makeInternetTariffPart1Test() {

        InternetTariffPart internetTariffPart = null;
        boolean flag = true;

        try {
            internetTariffPart = logic.makeInternetTariffPart("Internet   1000 2000 0.005");
        } catch (EntityMakingException e) {
            flag = false;
            e.printStackTrace();
        }

        Assert.assertTrue(flag);

        if (!flag){
            return;
        }

        String expectedName = "Internet";
        int expectedTrafficLimit = 1000;
        int expectedTrafficSpeedLimit = 2000;
        double expectedFee = 0.005;

        String actualName = internetTariffPart.getInternetTariffPartName();
        int actualTrafficLimit = internetTariffPart.getTrafficLimit();
        int actualTrafficSpeedLimit = internetTariffPart.getTrafficSpeedLimit();
        double actualFee = internetTariffPart.getTrafficFee();

        Assert.assertTrue(expectedName.equals(actualName));
        Assert.assertTrue(expectedTrafficLimit == actualTrafficLimit);
        Assert.assertTrue(expectedTrafficSpeedLimit == expectedTrafficSpeedLimit);
        Assert.assertTrue(expectedFee == actualFee);
    }

    @Test
    public void makeInternetTariffPart2Test() {

        InternetTariffPart internetTariffPart = null;
        boolean flag = true;

        try {
            internetTariffPart = logic.makeInternetTariffPart("Internet 1000 t 2000 0.005");
        } catch (EntityMakingException e) {
            flag = false;
        }

        Assert.assertFalse(flag);

    }
}
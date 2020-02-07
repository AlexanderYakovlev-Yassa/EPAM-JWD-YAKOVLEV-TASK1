package by.epam.yakovlev.task.entity_logic.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.jar.Attributes;

public class MobilProviderFactoryUtilTest {

    private static final EntityUtil UTIL = EntityUtil.getInstance();

    @Test
    public void parseStringToAttributesPositiveTest() {

        String testString = "name=Alexander age=44 eyes-color=blue hair-color=brown health-status=excellent";

        Attributes attributes = UTIL.ParseStringToAttributes(testString);

        Assert.assertNotNull(attributes);

        String excepted = "Alexander";
        String actual = attributes.getValue("name");
        Assert.assertTrue(actual.equals(excepted));

        excepted = "44";
        actual = attributes.getValue("age");
        Assert.assertTrue(actual.equals(excepted));

        excepted = "blue";
        actual = attributes.getValue("eyes-color");
        Assert.assertTrue(actual.equals(excepted));

        excepted = "brown";
        actual = attributes.getValue("hair-color");
        Assert.assertTrue(actual.equals(excepted));

        excepted = "excellent";
        actual = attributes.getValue("health-status");
        Assert.assertTrue(actual.equals(excepted));
    }

    @Test (expected = NullPointerException.class)
    public void parseStringToAttributesNegativeTest() {

        String testString = "name=Alexander ag=44 eyes-color=blue hair-color=brown health-status=excellent";

        Attributes attributes = UTIL.ParseStringToAttributes(testString);

        String excepted = "44";
        String actual = attributes.getValue("age");

        Assert.assertTrue(actual.equals(excepted));


    }

    @Test (expected = NullPointerException.class)
    public void parseStringToAttributesNegative1Test() {

        String testString = "name=Alexander age44 eyes-color=blue hair-color=brown health-status=excellent";

        Attributes attributes = UTIL.ParseStringToAttributes(testString);

        String excepted = "44";
        String actual = attributes.getValue("age");

        Assert.assertTrue(actual.equals(excepted));


    }
}
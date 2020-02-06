package by.epam.yakovlev.task.entity_logic.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.jar.Attributes;

import static org.junit.Assert.*;

public class ConverterUtilTest {

    private static final ConverterUtil UTIL = ConverterUtil.getINSTANCE();

    @Test
    public void parseStringToAttributesTest() {

        String testString = "name=Alexander age=44 eyes-color=blue hair-color=brown health-status=excellent";

        Attributes actual = UTIL.ParseStringToAttributes(testString);

        Assert.assertNotNull(actual);

        for (Object s : actual.keySet()){

            System.out.println(s + " " + actual.getValue(s.toString()));
        }
    }
}
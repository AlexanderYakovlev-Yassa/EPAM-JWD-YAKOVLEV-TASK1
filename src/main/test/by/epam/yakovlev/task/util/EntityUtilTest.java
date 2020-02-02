package by.epam.yakovlev.task.util;

import by.epam.yakovlev.task.exception.EntityMakingException;
import org.junit.Assert;
import org.junit.Test;

public class EntityUtilTest {

    private final static EntityUtil UTIL = EntityUtil.INSTANCE;

    @Test
    public void stringToPositiveDoubleTest() {

        String s_1 = "225.58";

        double actual = 0;
        double expected = 225.58;

        try {
            actual = UTIL.stringToPositiveDouble(s_1);
        } catch (EntityMakingException e) {

        }

        Assert.assertTrue(expected == actual);
    }

    @Test (expected = EntityMakingException.class)
    public void stringToPositiveDouble2Test() throws EntityMakingException {

        String s_1 = "225,58";

        double actual;
        double expected = 225.58;

        try {
            actual = UTIL.stringToPositiveDouble(s_1);
        } catch (EntityMakingException e) {
            throw e;
        }

        Assert.assertTrue(expected == actual);
    }

    @Test (expected = EntityMakingException.class)
    public void stringToPositiveDouble3Test() throws EntityMakingException {

        String s_1 = "-225.58";

        double actual;
        double expected = -225.58;

        try {
            actual = UTIL.stringToPositiveDouble(s_1);
        } catch (EntityMakingException e) {
            throw e;
        }

        Assert.assertTrue(expected == actual);
    }

    @Test
    public void stringToPositiveIntTest() {

        String s_1 = "225";

        int actual = 0;
        double expected = 225;

        try {
            actual = UTIL.stringToPositiveInt(s_1);
        } catch (EntityMakingException e) {

        }

        Assert.assertTrue(expected == actual);
    }

    @Test (expected = EntityMakingException.class)
    public void stringToPositiveInt2Test() throws EntityMakingException {

        String s_1 = "-225";

        double actual;
        double expected = -225;

        try {
            actual = UTIL.stringToPositiveDouble(s_1);
        } catch (EntityMakingException e) {
            throw e;
        }

        Assert.assertTrue(expected == actual);
    }

    @Test (expected = EntityMakingException.class)
    public void stringToPositiveInt3Test() throws EntityMakingException {

        String s_1 = "p25";

        double actual;
        double expected = 225;

        try {
            actual = UTIL.stringToPositiveDouble(s_1);
        } catch (EntityMakingException e) {
            throw e;
        }

        Assert.assertTrue(expected == actual);
    }
}
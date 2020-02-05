package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.repository.Repository;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class RepositoryImplTest {

    private static final Repository REPOSITORY = RepositoryImpl.INSTANCE;

    @Test
    public void initialiseTest() {

        REPOSITORY.initialise();

        HashSet<TariffExtension> t = new HashSet<TariffExtension>();

        t = REPOSITORY.getPhoneExtensions();

        Assert.assertTrue(t.size() > 0);

        t = new HashSet<TariffExtension>();
        t = REPOSITORY.getInternetExtensions();

        Assert.assertTrue(t.size() > 0);
    }
}
package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.exception.RepositoryException;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.RepositoryFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class RepositoryImplTest {

    private static final Repository REPOSITORY = RepositoryFactory.getINSTANCE().getREPOSITORY();

    @Test
    public void initialiseTest() {

        boolean actual = false;

        try {
            actual = REPOSITORY.initialise();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(actual);

    }
}
package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.exception.RepositoryException;
import by.epam.yakovlev.task.repository.RepositoryLogic;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class RepositoryLogicImplFileTest {

    private static RepositoryLogic repositoryLogic = Factory.INSTANCE.getRepositoryLogic();

    @Test
    public void getPhoneTariffPartSetTest() {

        HashSet<PhoneExtension> phoneTariffPartsSet = null;

        boolean flag = true;
        try {
            phoneTariffPartsSet = repositoryLogic.getPhoneTariffPartSet();
        } catch (RepositoryException e) {
            e.printStackTrace();
            flag = false;
        }

        Assert.assertNotNull(phoneTariffPartsSet);
    }
}
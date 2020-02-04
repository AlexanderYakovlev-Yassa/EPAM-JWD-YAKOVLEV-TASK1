package by.epam.yakovlev.task.dao.impl;

import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.exception.DAOException;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.*;

public class DAOLogicImplFileTest {

    private static final DAOLogicImplFile LOGIC = new DAOLogicImplFile();

    @Test
    public void getExtensionSetTest() {

        Optional<HashSet<TariffExtension>> res = Optional.empty();

        try {
            res = LOGIC.getExtensionSet(TariffExtensionTypes.PHONE);//change to test enum
        } catch (DAOException e) {
            //e.printStackTrace();
        }

        System.out.println(res.map(HashSet::size));
    }
}
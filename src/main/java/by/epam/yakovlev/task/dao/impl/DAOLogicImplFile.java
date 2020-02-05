package by.epam.yakovlev.task.dao.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;

import by.epam.yakovlev.task.entity_logic.impl.EntityCollectionConverterImpl;
import by.epam.yakovlev.task.exception.FileUtileException;
import by.epam.yakovlev.task.util.FileUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;

public enum DAOLogicImplFile implements DAOLogic {

INSTANCE;

    private final static FileUtil FILE_UTIL = FileUtil.INSTANCE;
    private final static Factory FACTORY = Factory.getInstance();
    private final static EntityCollectionConverter ENTITY_COLLECTION_CONVERTER = EntityCollectionConverterImpl.INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(DAOLogicImplFile.class);

    @Override
    public HashSet<TariffExtension> getExtensionSet(TariffExtensionTypes type) {

        ArrayList<String> list = null;
        HashSet<TariffExtension> res = new HashSet<TariffExtension>();

        try {
            list = FILE_UTIL.readFile(type.getSourceFile());
        } catch (FileUtileException e) {
            LOGGER.info("Fail access to the data source which contains phone tariff extensions");
            LOGGER.info(e);
            return res;
            //throw new DAOException("Fail access to the data source which contains phone tariff extensions", e);
        }

        if (list == null) {
            LOGGER.info("No such type records");
            return res;
            //throw new DAOException("No such type records");
        }

        res = ENTITY_COLLECTION_CONVERTER.convertToCollectionOf(list, type.getExtensionConverter());

        return res;
    }
}

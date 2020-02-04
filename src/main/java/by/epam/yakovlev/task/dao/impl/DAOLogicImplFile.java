package by.epam.yakovlev.task.dao.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;

import by.epam.yakovlev.task.entity_logic.ExtensionConverters;
import by.epam.yakovlev.task.exception.DAOException;
import by.epam.yakovlev.task.exception.FileUtileException;
import by.epam.yakovlev.task.util.FileUtil;
import org.apache.log4j.Logger;


import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;


public class DAOLogicImplFile implements DAOLogic {

    private final static FileUtil FILE_UTIL = FileUtil.INSTANCE;
    private final static Factory FACTORY = Factory.INSTANCE;
    private final static EntityCollectionConverter ENTITY_COLLECTION_CONVERTER =
            FACTORY.getEntityCollectionConverter();

    private static final Logger LOGGER = Logger.getLogger(DAOLogicImplFile.class);

    @Override
    public Optional<HashSet<TariffExtension>> getExtensionSet(TariffExtensionTypes type) throws DAOException {

        ArrayList<String> list = null;

        try {
            list = FILE_UTIL.readFile(type.getSourceFile());
        } catch (FileUtileException e) {
            LOGGER.info("Fail access to the data source which contains phone tariff extensions");
            LOGGER.info(e);
            throw new DAOException("Fail access to the data source which contains phone tariff extensions", e);
        }

        if (list == null) {
            LOGGER.info("No such type records");
            throw new DAOException("No such type records");
        }

        HashSet<TariffExtension> phoneTariffExtensionSet =
                ENTITY_COLLECTION_CONVERTER.convertToCollectionOf(list, type.getExtensionConverter());

        Optional<HashSet<TariffExtension>> res = Optional.of(phoneTariffExtensionSet);

        return res;
    }


}

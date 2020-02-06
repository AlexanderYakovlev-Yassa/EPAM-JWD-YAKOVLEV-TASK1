package by.epam.yakovlev.task.dao.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.DAOTablesEnum;
import by.epam.yakovlev.task.entity.ApplicationCompatibleType;
import by.epam.yakovlev.task.entity.EntityTypeEnum;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.entity_logic.ApplicationEntityFactory;
import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;

import by.epam.yakovlev.task.entity_logic.impl.EntityCollectionConverterImpl;
import by.epam.yakovlev.task.exception.DAOException;
import by.epam.yakovlev.task.exception.FileUtileException;
import by.epam.yakovlev.task.util.FileUtil;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class DAOLogicImplFile implements DAOLogic {

    //INSTANCE;

    private final static FileUtil FILE_UTIL = FileUtil.INSTANCE;
    private final static Factory FACTORY = Factory.getInstance();
    private final static EntityCollectionConverter ENTITY_COLLECTION_CONVERTER = EntityCollectionConverterImpl.INSTANCE;
    private final static ApplicationEntityFactory APPLICATION_ENTITY_FACTORY = FACTORY.getApplicationEntityFactory();

    private static Logger LOGGER = Logger.getLogger(DAOLogicImplFile.class);

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

    @Override
    public ArrayList<ApplicationCompatibleType> getList(DAOTablesEnum table) throws DAOException {

        ArrayList<String> stringRecordList = new ArrayList<String>();
        File file = new File(table.getFilePath());

        try {
            stringRecordList = FILE_UTIL.readFile(file);
        } catch (FileUtileException e) {
            LOGGER.debug("Fail access to file of [" + table.name() + "].");
            throw new DAOException("Fail access to the data source which contains phone tariff extensions", e);
        }

        ArrayList<ApplicationCompatibleType> res = new ArrayList<>();

        if (stringRecordList.isEmpty()) {
            LOGGER.debug("No records of [" + table.name() + "].");
            return res;
            //throw new DAOException("No such type records");
        }

        ApplicationCompatibleType temporaryEntity = null;
        EntityTypeEnum type = null;

        for (EntityTypeEnum e : EntityTypeEnum.values()) {

            if (e.name().equals(table.name())) {
                type = e;
                break;
            }
        }

        if (type == null) {
            LOGGER.debug("No type of [" + table.name() + "].");
            return res;
        }

        for (String s : stringRecordList) {

            temporaryEntity = null;
            temporaryEntity = APPLICATION_ENTITY_FACTORY.applicationEntityFactory(s, type);

            if (temporaryEntity != null){
                res.add(temporaryEntity);
            }
        }

        return res;
    }
}

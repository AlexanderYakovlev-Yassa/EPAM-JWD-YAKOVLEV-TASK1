package by.epam.yakovlev.task.dao.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.DAOTablesEnum;
import by.epam.yakovlev.task.entity.MobilProviderCompatibleType;
import by.epam.yakovlev.task.entity.EntityTypeEnum;
import by.epam.yakovlev.task.entity_logic.MobilProviderFactory;

import by.epam.yakovlev.task.exception.DAOException;
import by.epam.yakovlev.task.exception.FileUtileException;
import by.epam.yakovlev.task.util.FileUtil;

import java.io.File;
import java.util.ArrayList;

public class DAOLogicImplFile implements DAOLogic {

    private final Factory FACTORY = Factory.getInstance();
    private final FileUtil FILE_UTIL = new FileUtil();
    private final MobilProviderFactory APPLICATION_ENTITY_FACTORY = FACTORY.getMobilProviderFactory();

    //private Logger LOGGER = Logger.getLogger(DAOLogicImplFile.class);

    @Override
    public ArrayList<MobilProviderCompatibleType> getList(DAOTablesEnum table) throws DAOException {

        ArrayList<String> stringRecordList = new ArrayList<String>();
        File file = new File(table.getFilePath());

        try {
            stringRecordList = FILE_UTIL.readFile(file);
        } catch (FileUtileException e) {
            //LOGGER.debug("Fail access to file of [" + table.name() + "].");
            throw new DAOException("Fail access to the data source which contains phone tariff extensions", e);
        }

        ArrayList<MobilProviderCompatibleType> res = new ArrayList<>();

        if (stringRecordList.isEmpty()) {
            //LOGGER.debug("No records of [" + table.name() + "].");
            return res;
        }

        MobilProviderCompatibleType temporaryEntity = null;
        EntityTypeEnum type = null;

        for (EntityTypeEnum e : EntityTypeEnum.values()) {

            if (e.name().equals(table.name())) {
                type = e;
                break;
            }
        }

        if (type == null) {
            //LOGGER.debug("No type of [" + table.name() + "].");
            return res;
        }

        for (String s : stringRecordList) {

            temporaryEntity = APPLICATION_ENTITY_FACTORY.applicationEntityFactory(s, type);

            if (temporaryEntity != null){
                res.add(temporaryEntity);
            }
        }

        return res;
    }
}

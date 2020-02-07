package by.epam.yakovlev.task.dao.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.DAOTablesEnum;

import by.epam.yakovlev.task.exception.DAOException;
import by.epam.yakovlev.task.exception.FileUtileException;
import by.epam.yakovlev.task.util.FileUtil;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

public class DAOLogicImplFile implements DAOLogic {

    private final Factory FACTORY = Factory.getInstance();
    private final FileUtil FILE_UTIL = new FileUtil();

    private Logger LOGGER = Logger.getLogger(DAOLogicImplFile.class);

    @Override
    public ArrayList<String> getListOf(DAOTablesEnum table) throws DAOException {

        if (table == null){
            LOGGER.debug("There is no table [" + table.name() + "].");
            return  null;
        }

        ArrayList<String> stringRecordList = new ArrayList<String>();
        File file = new File(table.getFilePath());

        try {
            stringRecordList = FILE_UTIL.readFile(file);
        } catch (FileUtileException e) {
            LOGGER.debug("Fail access to file of [" + table.name() + "].");
            throw new DAOException("Fail access to the data source which contains phone tariff extensions", e);
        }

        return stringRecordList;
    }
}

package by.epam.yakovlev.task.dao;

import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.entity.MobilProviderCompatibleType;
import by.epam.yakovlev.task.exception.DAOException;

import java.util.ArrayList;

public interface DAOLogic {


    ArrayList<MobilProviderCompatibleType> getList(DAOTablesEnum table) throws DAOException;

}

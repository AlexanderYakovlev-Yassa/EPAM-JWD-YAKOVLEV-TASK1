package by.epam.yakovlev.task.dao;

import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.entity.ApplicationCompatibleType;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.exception.DAOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public interface DAOLogic {

    HashSet<TariffExtension> getExtensionSet(TariffExtensionTypes type);

    ArrayList<ApplicationCompatibleType> getList(DAOTablesEnum table) throws DAOException;

}

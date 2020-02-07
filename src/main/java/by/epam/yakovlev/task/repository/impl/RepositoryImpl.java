package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.dao.DAOFactory;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.DAOTablesEnum;
import by.epam.yakovlev.task.entity.*;
import by.epam.yakovlev.task.entity_logic.MobilProviderFactory;
import by.epam.yakovlev.task.exception.DAOException;
import by.epam.yakovlev.task.exception.RepositoryException;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.Specification;
import by.epam.yakovlev.task.repository.validator.RepositoryValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;

public class RepositoryImpl implements Repository {

    private final DAOLogic DAO_LOGIC = DAOFactory.getINSTANCE().getDAO_LOGIC();
    private final RepositoryValidator VALIDATOR = RepositoryValidator.getINSTANCE();
    private final MobilProviderFactory APPLICATION_ENTITY_FACTORY =
            Factory.getInstance().getMobilProviderFactory();

    private Logger LOGGER = Logger.getLogger(RepositoryImpl.class);

    private HashSet<MobilProviderCompatibleType> tariff;
    private HashSet<MobilProviderCompatibleType> phoneExtensionSet;
    private HashSet<MobilProviderCompatibleType> internetExtensionSet;

    @Override
    public MobilProviderCompatibleType getPhoneExtensionByName(String name) {

        for (MobilProviderCompatibleType t : phoneExtensionSet) {
            if (((PhoneExtension) t).getPhoneExtensionName().equals(name)) {
                return t;
            }
        }

        return null;
    }

    @Override
    public MobilProviderCompatibleType getInternetExtensionByName(String name) {

        for (MobilProviderCompatibleType t : internetExtensionSet) {
            if (((InternetExtension) t).getInternetExtensionName().equals(name)) {
                return t;
            }
        }

        return null;
    }

    @Override
    public ArrayList<MobilProviderCompatibleType> getResultList(Specification specification) {


        return null;
    }

    @Override
    public boolean initialise() throws RepositoryException {

        boolean atLeastOneTableInitialised = false;


        phoneExtensionSet = new HashSet<>();
        atLeastOneTableInitialised =
                fillTable(EntityTypeEnum.TARIFF_PHONE_EXTENSION);
        if (phoneExtensionSet != null) {
            LOGGER.debug("phoneExtensionSet initialised");
        } else {
            LOGGER.debug("phoneExtensionSet has not been initialised");
        }
        if (phoneExtensionSet.size() > 0) {
            LOGGER.debug("phoneExtensionSet has been filled");
            LOGGER.debug("phoneExtensionSet.size = " + phoneExtensionSet.size());
        } else {
            LOGGER.debug("phoneExtensionSet is empty");
        }

        internetExtensionSet = new HashSet<>();
        atLeastOneTableInitialised =
                fillTable(EntityTypeEnum.TARIFF_INTERNET_EXTENSION) || atLeastOneTableInitialised;

        if (internetExtensionSet != null) {
            LOGGER.debug("internetExtensionSet initialised");
        } else {
            LOGGER.debug("internetExtensionSet has not been initialised");
        }
        if (internetExtensionSet.size() > 0) {
            LOGGER.debug("internetExtensionSet has been filled");
            LOGGER.debug("internetExtensionSet.size = " + internetExtensionSet.size());
        } else {
            LOGGER.debug("internetExtensionSet is empty");
        }

        tariff = new HashSet<>();
        atLeastOneTableInitialised =
                fillTable(EntityTypeEnum.TARIFF) || atLeastOneTableInitialised;

        return atLeastOneTableInitialised;
    }

    private boolean fillTable(EntityTypeEnum table) throws RepositoryException {

        DAOTablesEnum daoTable = null;

        for (DAOTablesEnum e : DAOTablesEnum.values()) {
            if (table.name().equals(e.name())) {
                daoTable = e;
            }
        }

        ArrayList<String> entityList = null;

        try {
            entityList = DAO_LOGIC.getListOf(daoTable);
        } catch (DAOException e) {
            LOGGER.warn("Fail read the 'entity' table", e);
            return false;
        }

        if (entityList == null) {
            LOGGER.info("Nothing to add to the repository");
            return false;
        }

        boolean atLeastOneAdded = false;
        MobilProviderCompatibleType temporaryEntity = null;

        for (String str : entityList) {


            temporaryEntity = APPLICATION_ENTITY_FACTORY.applicationEntityFactory(str, table);

            switch (table) {
                case TARIFF_PHONE_EXTENSION: {
                    if (!VALIDATOR.isPhoneExtensionValid(temporaryEntity)) {
                        LOGGER.info("The phone tariff extension [" + str + "] is not valid and can't be added to repository");
                    }
                    TariffExtension tariffExtension = (TariffExtension) temporaryEntity;

                    if (phoneExtensionSet.add((PhoneExtension) tariffExtension)) {
                        atLeastOneAdded = true;
                    } else {
                        LOGGER.info("The phone tariff extension [" + str + "] is already in the repository");
                    }
                    break;
                }
                case TARIFF_INTERNET_EXTENSION: {
                    if (!VALIDATOR.isInternetExtensionValid(temporaryEntity)) {
                        LOGGER.info("The internet tariff extension [" + temporaryEntity + "] is not valid and can't be added to repository");
                    }
                    TariffExtension tariffExtension = (TariffExtension) temporaryEntity;

                    if (internetExtensionSet.add((InternetExtension) tariffExtension)) {
                        atLeastOneAdded = true;
                    } else {
                        LOGGER.info("The internet tariff extension [" + temporaryEntity + "] is already in the repository");
                    }
                    break;
                }
                case TARIFF: {
                    if (!VALIDATOR.isTariffValid(temporaryEntity)) {
                        LOGGER.info("The phone tariff extension [" + str + "] is not valid and can't be added to repository");
                    }
                    Tariff tariff = (Tariff) temporaryEntity;

                    if (this.tariff.add(tariff)) {
                        atLeastOneAdded = true;
                    } else {
                        LOGGER.info("The tariff [" + str + "] is already in the repository");
                    }
                }
            }
        }

        return atLeastOneAdded;
    }
}

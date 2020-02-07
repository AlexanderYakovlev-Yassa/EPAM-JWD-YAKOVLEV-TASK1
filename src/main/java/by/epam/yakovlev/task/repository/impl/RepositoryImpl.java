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

    private HashSet<Tariff> tariff;
    private HashSet<TariffExtension> phoneExtensionSet;
    private HashSet<TariffExtension> internetExtensionSet;

    public HashSet<Tariff> getTariff() {
        return tariff;
    }

    public void setTariff(HashSet<Tariff> tariff) {
        this.tariff = tariff;
    }

    public HashSet<TariffExtension> getPhoneExtensionSet() {
        return phoneExtensionSet;
    }


    public HashSet<TariffExtension> getInternetExtensionSet() {
        return internetExtensionSet;
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
                fillTable(EntityTypeEnum.TARIFF_PHONE_EXTENSION) ?
                        true :
                        atLeastOneTableInitialised;
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
                fillTable(EntityTypeEnum.TARIFF_INTERNET_EXTENSION) ?
                        true :
                        atLeastOneTableInitialised;

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
                fillTable(EntityTypeEnum.TARIFF) ?
                        true :
                        atLeastOneTableInitialised;

        //******************************************************************************************
        atLeastOneTableInitialised = atLeastOneTableInitialised ?
                atLeastOneTableInitialised :
                fillSIMCardTable();

        atLeastOneTableInitialised = atLeastOneTableInitialised ?
                atLeastOneTableInitialised :
                fillCustomerTable();

        return atLeastOneTableInitialised;
    }

    private boolean fillSIMCardTable() throws RepositoryException {
        return false;
    }

    private boolean fillCustomerTable() throws RepositoryException {
        return false;
    }



    private boolean fillTable(EntityTypeEnum table) throws RepositoryException {

        DAOTablesEnum daoTable = null;

        for (DAOTablesEnum e : DAOTablesEnum.values()) {
            if (table.name() == e.name()) {
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


     /*if (!VALIDATOR.isEntityValid(table, temporaryEntity)) {
     LOGGER.info("The 'entity' [" + str + "] is not valid and can't be added to repository");
     }
     TariffExtension tariffExtension = (TariffExtension) temporaryEntity;*/

            switch (table) {
                case TARIFF_PHONE_EXTENSION: {
                    if (!VALIDATOR.isPhoneExtensionValid(temporaryEntity)) {
                        LOGGER.info("The phone tariff extension [" + str + "] is not valid and can't be added to repository");
                    }
                    TariffExtension tariffExtension = (TariffExtension) temporaryEntity;

                    if (phoneExtensionSet.add(tariffExtension)) {
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

                    if (internetExtensionSet.add(tariffExtension)) {
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

    /******************************

     private boolean fillPhoneExtensionTable() throws RepositoryException {

     ArrayList<String> phoneExtensionList = null;

     try {
     phoneExtensionList = DAO_LOGIC.getListOf(DAOTablesEnum.TARIFF_PHONE_EXTENSION);
     } catch (DAOException e) {
     LOGGER.warn("Fail read the phone extension table", e);
     return false;
     }

     if (phoneExtensionList == null) {
     LOGGER.info("Nothing to add to the repository");
     return false;
     }

     boolean atLeastOneAdded = false;
     MobilProviderCompatibleType temporaryEntity = null;
     EntityTypeEnum type = EntityTypeEnum.TARIFF_PHONE_EXTENSION;
     for (String str : phoneExtensionList) {


     temporaryEntity = APPLICATION_ENTITY_FACTORY.applicationEntityFactory(str, type);


     if (!VALIDATOR.isPhoneExtensionValid(temporaryEntity)) {
     LOGGER.info("The phone tariff extension [" + str + "] is not valid and can't be added to repository");
     }
     TariffExtension tariffExtension = (TariffExtension) temporaryEntity;

     if (phoneExtensionSet.add(tariffExtension)) {
     atLeastOneAdded = true;
     } else {
     LOGGER.info("The phone tariff extension [" + str + "] is already in the repository");
     }
     }

     return atLeastOneAdded;
     }

     private boolean fillInternetExtensionTable() {

     LOGGER.debug("fillInternetExtensionTable runs");

     ArrayList<String> internetExtensionList = null;

     try {
     internetExtensionList = DAO_LOGIC.getListOf(DAOTablesEnum.TARIFF_INTERNET_EXTENSION);
     } catch (DAOException e) {
     LOGGER.warn("Fail read the internet extension table", e);
     return false;
     }

     if (internetExtensionList == null) {
     LOGGER.info("Nothing to add to the repository");
     return false;
     }

     /*boolean atLeastOneAddwd = false;
     for (MobilProviderCompatibleType m : internetExtensionList) {

     if (!VALIDATOR.isInternetExtensionValid(m)) {
     LOGGER.info("The internet tariff extension [" + m.toString() + "] is not valid and can't be added to repository");
     }
     TariffExtension tariffExtension = (TariffExtension) m;

     if (internetExtensionSet.add(tariffExtension)) {
     atLeastOneAddwd = true;
     } else {
     LOGGER.info("The internet tariff extension [" + m.toString() + "] is already in the repository");
     }
     }
     boolean atLeastOneAdded = false;
     MobilProviderCompatibleType temporaryEntity = null;
     EntityTypeEnum type = EntityTypeEnum.TARIFF_INTERNET_EXTENSION;
     for (String str : phoneExtensionList) {


     temporaryEntity = APPLICATION_ENTITY_FACTORY.applicationEntityFactory(str, type);


     if (!VALIDATOR.isPhoneExtensionValid(temporaryEntity)) {
     LOGGER.info("The phone tariff extension [" + str + "] is not valid and can't be added to repository");
     }
     TariffExtension tariffExtension = (TariffExtension) temporaryEntity;

     if (phoneExtensionSet.add(tariffExtension)) {
     atLeastOneAdded = true;
     } else {
     LOGGER.info("The phone tariff extension [" + str + "] is already in the repository");
     }
     }

     return atLeastOneAddwd;
     }

     public TariffExtension getExtension(TariffExtensionTables table, String name) {

     if (name == null) {
     return null;
     }

     for (TariffExtension t : phoneExtensionSet) {
     switch (table) {
     case PHONE: {
     if (((PhoneExtension) t).getPhoneExtensionName() == name) {
     return t;
     }
     }
     case INTERNET: {
     if (((InternetExtension) t).getInternetExtensionName() == name) {
     return t;
     }
     }
     }
     }

     return null;
     }

     //*******************************************************************************
     private boolean fillTariffTable() {

     LOGGER.debug("fillTariffExtensionTable runs");

     ArrayList<MobilProviderCompatibleType> tariffList = null;

     try {
     tariffList = DAO_LOGIC.getListOf(DAOTablesEnum.TARIFF);
     } catch (DAOException e) {
     LOGGER.warn("Fail read the internet extension table", e);
     return false;
     }

     if (tariffList == null) {
     LOGGER.info("Nothing to add to the repository");
     return false;
     }

     boolean atLeastOneAddwd = false;
     for (MobilProviderCompatibleType m : tariffList) {

     if (!VALIDATOR.isInternetExtensionValid(m)) {
     LOGGER.info("The internet tariff extension [" + m.toString() + "] is not valid and can't be added to repository");
     }
     TariffExtension tariffExtension = (TariffExtension) m;

     if (internetExtensionSet.add(tariffExtension)) {
     atLeastOneAddwd = true;
     } else {
     LOGGER.info("The internet tariff extension [" + m.toString() + "] is already in the repository");
     }
     }

     return atLeastOneAddwd;
     }
     ***************************************/
}

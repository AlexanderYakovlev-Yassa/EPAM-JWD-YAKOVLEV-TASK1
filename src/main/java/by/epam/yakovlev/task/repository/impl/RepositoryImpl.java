package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.dao.DAOFactory;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;
import by.epam.yakovlev.task.entity.InternetExtension;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.entity.Tariff;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.RepositoryTablesEnum;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;

public class  RepositoryImpl implements Repository {

    private static final RepositoryImpl INSTANCE = new RepositoryImpl();

    private Factory FACTORY = Factory.getInstance();
    //private DAOLogic DAO_LOGIC = DAOFactory.getInstance().getDaoLogic();
    private Logger LOGGER = Logger.getLogger(RepositoryImpl.class);

    private HashSet<Tariff> tariff;
    private HashSet<TariffExtension> phoneExtensions;
    private HashSet<TariffExtension> internetExtensions;

    private RepositoryImpl(){
    }

    public static RepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void initialise() {

        //setPhoneExtensions(DAO_LOGIC.getExtensionSet(TariffExtensionTypes.PHONE));
        //setInternetExtensions(DAO_LOGIC.getExtensionSet(TariffExtensionTypes.INTERNET));


    }

    public HashSet<Tariff> getTariff() {
        return tariff;
    }

    public void setTariff(HashSet<Tariff> tariff) {
        this.tariff = tariff;
    }

    public HashSet<TariffExtension> getPhoneExtensions() {
        return phoneExtensions;
    }


    public HashSet<TariffExtension> getInternetExtensions() {
        return internetExtensions;
    }

    @Override
    public TariffExtension findExtensionByTypeAndName(String type, String name) {

        if (type == null || name == null){
            LOGGER.info("Can't find tariff extension by null type or name");
            return null;
        }

        TariffExtension res = null;

        switch (name.toUpperCase()){
            case "PHONE" :{

                for (TariffExtension t : phoneExtensions){
                    if (((PhoneExtension)t).getPhoneExtensionName() == name){
                        res = t;
                    }
                }
                break;
            }
            case "INTERNET" :{
                for (TariffExtension t : internetExtensions){
                    if (((InternetExtension)t).getInternetExtensionName() == name){
                        res = t;
                    }
                }
                break;
            }
            default:{
                LOGGER.info("There is no type [" + name.toUpperCase() + "].");
                return null;
            }
        }

        return res;
    }

    @Override
    public ArrayList<Tariff> getAllTariff() {
        return null;
    }

    @Override
    public <T> ArrayList<T> getAllRecordsList(RepositoryTablesEnum table) {
        return null;
    }

    @Override
    public boolean fillTable(RepositoryTablesEnum table) {
        return false;
    }

    public void setPhoneExtensions(HashSet<TariffExtension> phoneExtensions) {
        this.phoneExtensions = phoneExtensions;
    }

    public void setInternetExtensions(HashSet<TariffExtension> internetExtensions) {
        this.internetExtensions = internetExtensions;
    }
}

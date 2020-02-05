package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.TariffExtensionTypes;
import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;
import by.epam.yakovlev.task.entity.InternetExtension;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.entity.Tariff;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.repository.Repository;

import java.util.HashSet;
import java.util.Optional;

public enum  RepositoryImpl implements Repository {

INSTANCE;

    private final DAOLogic DAO_LOGIC = DAOLogicImplFile.INSTANCE;

    private HashSet<Tariff> tariff;
    private Optional<HashSet<TariffExtension>> phoneExtensions;
    private Optional<HashSet<TariffExtension>> internetExtensions;

    RepositoryImpl(){
        tariff = new HashSet<Tariff>();
        phoneExtensions = Optional.empty();
        internetExtensions = Optional.empty();
    }

    @Override
    public void initialise() {

        setPhoneExtensions(DAO_LOGIC.getExtensionSet(TariffExtensionTypes.PHONE));
        setInternetExtensions(DAO_LOGIC.getExtensionSet(TariffExtensionTypes.INTERNET));


    }

    public HashSet<Tariff> getTariff() {
        return tariff;
    }

    public void setTariff(HashSet<Tariff> tariff) {
        this.tariff = tariff;
    }

    public Optional<HashSet<TariffExtension>> getPhoneExtensions() {
        return phoneExtensions;
    }


    public Optional<HashSet<TariffExtension>> getInternetExtensions() {
        return internetExtensions;
    }

    @Override
    public Optional<TariffExtension> findPhoneExtensionByName(String name) {

        Optional<TariffExtension> res = Optional.empty();

        HashSet<TariffExtension> phoneExtensions = this.phoneExtensions.orElse(new HashSet<TariffExtension>());

        for (TariffExtension t : phoneExtensions){
            if (((PhoneExtension)t).getPhoneExtensionName() == name){
                return Optional.of(t);
            }
        }

        return res;
    }

    public void setPhoneExtensions(Optional<HashSet<TariffExtension>> phoneExtensions) {
        this.phoneExtensions = phoneExtensions;
    }

    public void setInternetExtensions(Optional<HashSet<TariffExtension>> internetExtensions) {
        this.internetExtensions = internetExtensions;
    }
}

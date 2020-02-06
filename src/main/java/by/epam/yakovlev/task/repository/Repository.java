package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.Tariff;
import by.epam.yakovlev.task.entity.TariffExtension;

import java.util.ArrayList;
import java.util.HashSet;

public interface Repository {


    void initialise();

    HashSet<TariffExtension> getPhoneExtensions();
    HashSet<TariffExtension> getInternetExtensions();

    TariffExtension findExtensionByTypeAndName(String type, String name);

    ArrayList<Tariff> getAllTariff();

    <T> ArrayList<T> getAllRecordsList(RepositoryTablesEnum table);

    boolean fillTable(RepositoryTablesEnum table);

}

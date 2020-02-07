package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.MobilProviderCompatibleType;
import by.epam.yakovlev.task.entity.Tariff;
import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.exception.RepositoryException;
import by.epam.yakovlev.task.repository.impl.TariffExtensionTables;

import java.util.ArrayList;
import java.util.HashSet;

public interface Repository {

    //TariffExtension getExtension(TariffExtensionTables tables, String name);
    //HashSet<TariffExtension> getInternetExtensionSet();

    //TariffExtension findExtensionByTypeAndName(String type, String name);

    //ArrayList<Tariff> getAllTariff();

    ArrayList<MobilProviderCompatibleType> getResultList(Specification specification);

    boolean initialise() throws RepositoryException;

}

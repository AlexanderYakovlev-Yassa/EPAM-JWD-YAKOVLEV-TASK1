package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.MobilProviderCompatibleType;
import by.epam.yakovlev.task.exception.RepositoryException;

import java.util.ArrayList;

public interface Repository {

    MobilProviderCompatibleType getPhoneExtensionByName(String name);
    MobilProviderCompatibleType getInternetExtensionByName(String name);

    ArrayList<MobilProviderCompatibleType> getResultList(Specification specification);

    boolean initialise() throws RepositoryException;

}

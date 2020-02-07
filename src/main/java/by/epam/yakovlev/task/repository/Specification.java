package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.MobilProviderCompatibleType;

import java.util.ArrayList;
import java.util.HashSet;

public interface Specification {

    ArrayList<MobilProviderCompatibleType> isMatched(String name, HashSet<MobilProviderCompatibleType> set);
    RepositoryTablesEnum getTable();
}

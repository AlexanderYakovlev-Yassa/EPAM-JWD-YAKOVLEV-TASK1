package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.entity.ApplicationCompatibleType;
import by.epam.yakovlev.task.repository.RepositoryTablesEnum;

public interface Converter {

    ApplicationCompatibleType ConvertFromStringToEntity(String string, RepositoryTablesEnum table);
}
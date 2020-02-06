package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.entity.ApplicationCompatibleType;
import by.epam.yakovlev.task.entity.EntityTypeEnum;
import by.epam.yakovlev.task.repository.RepositoryTablesEnum;

public interface ApplicationEntityFactory {

    ApplicationCompatibleType applicationEntityFactory(String string, EntityTypeEnum type);
}

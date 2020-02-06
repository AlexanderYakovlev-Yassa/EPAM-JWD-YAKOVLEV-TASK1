package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.entity.MobilProviderCompatibleType;
import by.epam.yakovlev.task.entity.EntityTypeEnum;

public interface MobilProviderFactory {

    MobilProviderCompatibleType applicationEntityFactory(String string, EntityTypeEnum type);
}

package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.EntityType;
import by.epam.yakovlev.task.entity.TariffExtension;

import java.util.Optional;

public interface ExtensionConverter {

    TariffExtension convertToTariffExtension(String string);
}

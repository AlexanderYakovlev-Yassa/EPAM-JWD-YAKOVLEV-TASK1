package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.entity.TariffExtension;

import java.util.ArrayList;
import java.util.HashSet;

public interface EntityCollectionConverter {

    HashSet<TariffExtension> convertToCollectionOf(ArrayList<String> list, ExtensionConverter converter);
}

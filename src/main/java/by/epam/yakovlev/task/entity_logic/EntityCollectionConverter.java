package by.epam.yakovlev.task.entity_logic;

import java.util.ArrayList;
import java.util.HashSet;

public interface EntityCollectionConverter {

    <T> HashSet<T> convertToCollectionOf(ArrayList<String> list, ExtensionConverter converter);
}

package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.entity.TariffExtension;
import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;
import by.epam.yakovlev.task.entity_logic.ExtensionConverter;

import java.util.ArrayList;
import java.util.HashSet;

public enum  EntityCollectionConverterImpl implements EntityCollectionConverter {

    INSTANCE;

    @Override
    public HashSet<TariffExtension> convertToCollectionOf(ArrayList<String> list, ExtensionConverter converter) {

        HashSet<TariffExtension> set = new HashSet<TariffExtension>();

        if (list == null || converter == null){
            return set;
        }

        for (String s : list){
            set.add(converter.convertToTariffExtension(s));
        }

        return set;
    }
}



package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;
import by.epam.yakovlev.task.entity_logic.ExtensionConverter;

import java.util.ArrayList;
import java.util.HashSet;

public class EntityCollectionConverterImpl implements EntityCollectionConverter {
    /*@Override
    public <T> HashSet<T> convertToCollectionOf(ArrayList<String> list, T type) {

        switch (type.getClass().getName()){
            case "by.epam.yakovlev.task.entity.PhoneExtension": {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        PhoneExtension p = new PhoneExtension();
        System.out.println(p.getClass().getName());
    }*/

    @Override
    public <T> HashSet<T> convertToCollectionOf(ArrayList<String> list, ExtensionConverter converter) {
        return null;
    }
}



package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.entity_logic.impl.ToInternetTariffExtensionConverter;
import by.epam.yakovlev.task.entity_logic.impl.ToPhoneTariffExtensionConverter;

public enum ExtensionConverters {

    PHONE(new ToPhoneTariffExtensionConverter()),
    INTERNET(new ToInternetTariffExtensionConverter());

    ExtensionConverter converter;

    ExtensionConverters(ExtensionConverter converter) {
        this.converter = converter;
    }

    public ExtensionConverter getConverter(){
        return converter;
    }
}

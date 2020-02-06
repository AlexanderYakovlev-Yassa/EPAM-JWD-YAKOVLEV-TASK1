package by.epam.yakovlev.task;

import by.epam.yakovlev.task.entity_logic.MobilProviderFactory;
import by.epam.yakovlev.task.entity_logic.impl.MobilProviderFactoryImpl;

public class Factory {

    private final static Factory INSTANCE = new Factory();

    private MobilProviderFactory mobilProviderFactory = new MobilProviderFactoryImpl();

    private Factory(){
    }

    public static Factory getInstance(){
        return INSTANCE;
    }

    public MobilProviderFactory getMobilProviderFactory() {
        return mobilProviderFactory;
    }

}

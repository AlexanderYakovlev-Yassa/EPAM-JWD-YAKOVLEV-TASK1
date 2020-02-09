package by.epam.yakovlev.task;

import by.epam.yakovlev.task.entity_logic.OldMobilProviderFactory;
import by.epam.yakovlev.task.entity_logic.impl.OldMobilProviderFactoryImpl;

public class Factory {

    private final static Factory INSTANCE = new Factory();

    private OldMobilProviderFactory mobilProviderFactory = new OldMobilProviderFactoryImpl();

    private Factory(){
    }

    public static Factory getInstance(){
        return INSTANCE;
    }

    public OldMobilProviderFactory getMobilProviderFactory() {
        return mobilProviderFactory;
    }

}

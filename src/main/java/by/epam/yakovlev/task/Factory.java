package by.epam.yakovlev.task;

import by.epam.yakovlev.task.entity_logic.EntityLogic;
import by.epam.yakovlev.task.entity_logic.impl.EntityLogicImpl;

public enum Factory {

    INSTANCE;

    private static EntityLogic entityLogic = EntityLogicImpl.INSTANCE;

    public EntityLogic getEntityLogic(){
        return entityLogic;
    }
}

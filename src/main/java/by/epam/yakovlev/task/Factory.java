package by.epam.yakovlev.task;


import by.epam.yakovlev.task.entity_logic.EntityLogic;
import by.epam.yakovlev.task.repository.RepositoryLogic;
import by.epam.yakovlev.task.repository.impl.RepositoryLogicImplFile;

public enum Factory {

    INSTANCE;

    //private static EntityLogic entityLogic = EntityLogicImpl.INSTANCE;
    private static RepositoryLogic repositoryLogic = RepositoryLogicImplFile.INSTANCE;

    /*public EntityLogic getEntityLogic(){
        return entityLogic;
    }*/

    public RepositoryLogic getRepositoryLogic(){
        return repositoryLogic;
    }
}

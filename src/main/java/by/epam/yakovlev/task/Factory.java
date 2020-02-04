package by.epam.yakovlev.task;


import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;
import by.epam.yakovlev.task.entity_logic.EntityLogic;
import by.epam.yakovlev.task.entity_logic.impl.EntityCollectionConverterImpl;
import by.epam.yakovlev.task.repository.RepositoryLogic;
import by.epam.yakovlev.task.repository.impl.RepositoryLogicImplFile;

public enum Factory {

    INSTANCE;

    private RepositoryLogic repositoryLogic = RepositoryLogicImplFile.INSTANCE;
    private EntityCollectionConverter entityCollectionConverter = EntityCollectionConverterImpl.INSTANCE;

    public RepositoryLogic getRepositoryLogic(){
        return repositoryLogic;
    }

    public EntityCollectionConverter getEntityCollectionConverter(){
        return entityCollectionConverter;
    }
}

package by.epam.yakovlev.task;


import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;
import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;
import by.epam.yakovlev.task.entity_logic.impl.EntityCollectionConverterImpl;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.impl.RepositoryImpl;
//import by.epam.yakovlev.task.repository.impl.RepositoryLogicImplFile;

public enum Factory {

    INSTANCE;

    //private Repository repositoryLogic = RepositoryLogicImplFile.INSTANCE;
    private EntityCollectionConverter entityCollectionConverter = EntityCollectionConverterImpl.INSTANCE;
    private DAOLogic daoLogic = DAOLogicImplFile.INSTANCE;
    private Repository repository = RepositoryImpl.INSTANCE;
    /*public Repository getRepositoryLogic(){
        return repositoryLogic;
    }*/

    public EntityCollectionConverter getEntityCollectionConverter(){
        return entityCollectionConverter;
    }

    public DAOLogic getDaoLogic(){
        return daoLogic;
    }
    public Repository getRepository(){
        return repository;
    }
}

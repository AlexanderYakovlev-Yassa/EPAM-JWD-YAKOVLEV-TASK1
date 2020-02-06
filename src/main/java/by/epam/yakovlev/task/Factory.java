package by.epam.yakovlev.task;


import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;
import by.epam.yakovlev.task.entity_logic.ApplicationEntityFactory;
import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;
import by.epam.yakovlev.task.entity_logic.impl.ApplicationEntityFactoryImpl;
import by.epam.yakovlev.task.entity_logic.impl.EntityCollectionConverterImpl;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.impl.RepositoryImpl;

public class Factory {

    private final static Factory INSTANCE = new Factory();

    //private DAOLogic DAO_LOGIC = new DAOLogicImplFile();
    private Repository REPOSITORY = RepositoryImpl.getInstance();
    private EntityCollectionConverter ENTITY_COLLECTION_CONVERTER = EntityCollectionConverterImpl.INSTANCE;

    //*********** new gen

    private ApplicationEntityFactory applicationEntityFactory = new ApplicationEntityFactoryImpl();


    //*******************


    private Factory(){
    }

    public static Factory getInstance(){
        return INSTANCE;
    }

    /*public DAOLogic getDAOLogic() {
        return DAO_LOGIC;
    }*/

    public Repository getRepository() {
        return REPOSITORY;
    }

    public EntityCollectionConverter getEntityCollectionConverter() {
        return ENTITY_COLLECTION_CONVERTER;
    }

    //************** new gen
    public ApplicationEntityFactory getApplicationEntityFactory() {
        return applicationEntityFactory;
    }
}

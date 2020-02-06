package by.epam.yakovlev.task;


import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;
import by.epam.yakovlev.task.entity_logic.Converter;
import by.epam.yakovlev.task.entity_logic.EntityCollectionConverter;
import by.epam.yakovlev.task.entity_logic.impl.ConverterImpl;
import by.epam.yakovlev.task.entity_logic.impl.EntityCollectionConverterImpl;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.impl.RepositoryImpl;

public class Factory {

    private final static Factory INSTANCE = new Factory();

    private DAOLogic DAO_LOGIC = DAOLogicImplFile.INSTANCE;
    private Repository REPOSITORY = RepositoryImpl.INSTANCE;
    private EntityCollectionConverter ENTITY_COLLECTION_CONVERTER = EntityCollectionConverterImpl.INSTANCE;

    //*********** new gen

    private Converter converter = new ConverterImpl();


    //*******************


    private Factory(){
    }

    public static Factory getInstance(){
        return INSTANCE;
    }

    public DAOLogic getDAOLogic() {
        return DAO_LOGIC;
    }

    public Repository getRepository() {
        return REPOSITORY;
    }

    public EntityCollectionConverter getEntityCollectionConverter() {
        return ENTITY_COLLECTION_CONVERTER;
    }

    //************** new gen
    public Converter getConverter() {
        return converter;
    }
}

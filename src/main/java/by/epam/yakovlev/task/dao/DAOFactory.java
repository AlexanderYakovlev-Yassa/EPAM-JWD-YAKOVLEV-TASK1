package by.epam.yakovlev.task.dao;

import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;

public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private final DAOLogic DAO_LOGIC = new DAOLogicImplFile();

    public DAOFactory() {
    }

    public static DAOFactory getINSTANCE() {
        return INSTANCE;
    }

    public DAOLogic getDAO_LOGIC() {
        return DAO_LOGIC;
    }
}

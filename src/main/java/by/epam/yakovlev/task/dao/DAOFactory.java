package by.epam.yakovlev.task.dao;

import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;

public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private DAOLogic daoLogic = new DAOLogicImplFile();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public DAOLogic getDaoLogic() {
        return daoLogic;
    }
}

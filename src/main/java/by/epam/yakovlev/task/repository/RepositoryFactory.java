package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.repository.impl.RepositoryImpl;

public class RepositoryFactory {

    private static final RepositoryFactory INSTANCE = new RepositoryFactory();

    private final Repository REPOSITORY = new RepositoryImpl();

    public RepositoryFactory() {
    }

    public static RepositoryFactory getINSTANCE() {
        return INSTANCE;
    }

    public Repository getREPOSITORY() {
        return REPOSITORY;
    }
}

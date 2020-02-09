package by.epam.yakovlev.task.repository;


import by.epam.yakovlev.task.repository.impl.RepositoryImplementation;

public class RepositoryFactory {

    private static final RepositoryFactory INSTANCE = new RepositoryFactory();

    private Repository repository = RepositoryImplementation.getINSTANCE();

    private RepositoryFactory() {
    }

    public static RepositoryFactory getINSTANCE() {
        return INSTANCE;
    }

    public Repository getRepository() {
        return repository;
    }
}

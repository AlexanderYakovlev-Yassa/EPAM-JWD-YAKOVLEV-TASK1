package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.RepositoryCompatibleType;

import java.util.ArrayList;
import java.util.Optional;

public interface Repository {

    void addEntity(Optional<RepositoryCompatibleType> entity);
    void removeEntity(Optional<RepositoryCompatibleType> entity);
    boolean updateEntity(Optional<RepositoryCompatibleType> entity);

    ArrayList<Optional<RepositoryCompatibleType>> getResultList(Specification specification);
}

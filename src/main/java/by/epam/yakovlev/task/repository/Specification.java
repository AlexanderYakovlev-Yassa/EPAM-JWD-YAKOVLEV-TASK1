package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.RepositoryCompatibleType;
import by.epam.yakovlev.task.repository.impl.RepositoryTablesEnum;

import java.util.ArrayList;
import java.util.HashSet;

public interface Specification {

   boolean specified(RepositoryCompatibleType entity);
}

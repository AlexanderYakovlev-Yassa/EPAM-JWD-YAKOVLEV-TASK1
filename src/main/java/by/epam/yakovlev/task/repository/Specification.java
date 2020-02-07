package by.epam.yakovlev.task.repository;

public interface Specification {

    boolean isMatched(String requestParameters);
}

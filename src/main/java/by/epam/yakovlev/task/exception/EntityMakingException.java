package by.epam.yakovlev.task.exception;

public class EntityMakingException extends Exception{

    public EntityMakingException() {
    }

    public EntityMakingException(String message) {
        super(message);
    }

    public EntityMakingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityMakingException(Throwable cause) {
        super(cause);
    }
}

package by.epam.yakovlev.task.exception;

public class FileUtileException extends Exception {

    public FileUtileException() {
    }

    public FileUtileException(String message) {
        super(message);
    }

    public FileUtileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUtileException(Throwable cause) {
        super(cause);
    }
}

package by.epam.yakovlev.task;

public enum StringConstant {
    NO_NAME("no_name"),
    EMPTY_STRING(""),
    FIELD_DELIMITER("[\\s]+"),
    PARAMETER_DELIMITER("=");

    String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}

package by.epam.yakovlev.task;

public enum StringConstant {
    NO_NAME("no_name");

    String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

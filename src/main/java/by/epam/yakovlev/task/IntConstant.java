package by.epam.yakovlev.task;

public enum IntConstant {
    MAX_CURRENCY_DIVIDER(1000),
    ZERO(0);

    int value;

    IntConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package by.epam.yakovlev.task.dao;

public enum DAOTablesEnum {

    TARIFF("src\\main\\resources\\data_file\\TariffList.txt"),
    TARIFF_PHONE_EXTENSION("src\\main\\resources\\data_file\\PhoneExtensionList.txt"),
    TARIFF_INTERNET_EXTENSION("src\\main\\resources\\data_file\\InternetExtensionList.txt"),
    CUSTOMER("src\\main\\resources\\data_file\\CustomerList.txt"),
    SIM_CARD("src\\main\\resources\\data_file\\SIMCardList.txt");

    private String filePath;

    DAOTablesEnum(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}

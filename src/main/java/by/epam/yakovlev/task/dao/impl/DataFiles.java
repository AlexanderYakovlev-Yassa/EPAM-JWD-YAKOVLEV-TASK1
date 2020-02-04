package by.epam.yakovlev.task.dao.impl;

import java.io.File;

public enum DataFiles {

    PHONE_EXTENSION_LIST(new File("src\\main\\resources\\data_file\\PhoneExtensionList.txt")),
    INTERNET_EXTENSION_LIST(new File("src\\main\\resources\\data_file\\InternetExtensionList.txt")),
    TARIFF_LIST(new File("src\\main\\resources\\data_file\\TariffList.txt"));

    private File file;

    DataFiles(File file){
        this.file = file;
    }

    public File getFile(){
        return file;
    }
}

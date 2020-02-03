package by.epam.yakovlev.task.data;

import java.io.File;

public enum DataFiles {

    PHONE_PART(new File("src\\main\\java\\by\\epam\\yakovlev\\task\\data\\PhonePartList.txt")),
    INTERNET_PART(new File("src\\main\\java\\by\\epam\\yakovlev\\task\\data\\InternetPartList.txt")),
    MOBILE_PHONE_TARIFFS(new File("src\\main\\java\\by\\epam\\yakovlev\\task\\data\\MobilePhoneTariffList.txt")),
    INTERNET_TARIFFS(new File("src\\main\\test\\by\\epam\\yakovlev\\task\\data\\InternetTariffList.txt")),
    SMART_PHONE_TARIFFS(new File("src\\main\\test\\by\\epam\\yakovlev\\task\\data\\SmartPhoneTariffList.txt"));

    private File file;

    DataFiles(File file){
        this.file = file;
    }

    public File getFile(){
        return file;
    }
}

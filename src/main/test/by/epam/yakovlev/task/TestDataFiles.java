package by.epam.yakovlev.task;

import java.io.File;

public enum TestDataFiles {

    PHONE_PART(new File("src\\main\\test\\by\\epam\\yakovlev\\task\\data\\PhoneParts.txt")),
    INTERNET_PART(new File("src\\main\\test\\by\\epam\\yakovlev\\task\\data\\")),
    MOBILE_PHONE_TARIFFS(new File("src\\main\\test\\by\\epam\\yakovlev\\task\\data\\")),
    INTERNET_TARIFFS(new File("src\\main\\test\\by\\epam\\yakovlev\\task\\data\\")),
    SMART_PHONE_TARIFFS(new File("src\\main\\test\\by\\epam\\yakovlev\\task\\data\\"));

    private File file;

    TestDataFiles(File file){
        this.file = file;
    }

    public File getFile(){
        return file;
    }
}

package by.epam.yakovlev.task;

import by.epam.yakovlev.task.entity_logic.ExtensionConverter;
import by.epam.yakovlev.task.entity_logic.impl.ToInternetTariffExtensionConverter;
import by.epam.yakovlev.task.entity_logic.impl.ToPhoneTariffExtensionConverter;

import java.io.File;

public enum TariffExtensionTypes {

    PHONE(new File("src\\main\\resources\\data_file\\PhoneExtensionList.txt"),
            new ToPhoneTariffExtensionConverter()),
    INTERNET(new File("src\\main\\resources\\data_file\\InternetExtensionList.txt"),
            new ToInternetTariffExtensionConverter());

    private File sourceFile;
    private ExtensionConverter extensionConverter;

    TariffExtensionTypes(File sourceFile, ExtensionConverter extensionConverter) {
        this.sourceFile = sourceFile;
        this.extensionConverter = extensionConverter;
    }

    public File getSourceFile(){
        return sourceFile;
    }

    public ExtensionConverter getExtensionConverter(){
        return extensionConverter;
    }
}

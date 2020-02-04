package by.epam.yakovlev.task.dao.impl;

import by.epam.yakovlev.task.dao.DAOLogic;
import by.epam.yakovlev.task.DataFiles;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.exception.DAOException;
import by.epam.yakovlev.task.exception.FileUtileException;
import by.epam.yakovlev.task.util.FileUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class DAOLogicImplFile implements DAOLogic {

private final static FileUtil FILE_UTIL = FileUtil.INSTANCE;

    @Override
    public Optional<HashSet<PhoneExtension>> getPhoneExtensionSet() throws DAOException {
        ArrayList<String> list = null;

        try {
            list = FILE_UTIL.readFile(DataFiles.PHONE_PART.getFile());
        } catch (FileUtileException e) {
            throw new DAOException("Fail access to repository 'phone part'", e);
        }

        //HashSet<PhoneExtension> phoneTariffPartSet = convertToPhonePartSet(list);

        return Optional.empty();
    }

    @Override
    public Optional<HashSet<PhoneExtension>> getInternetExtensionSet() {
        return Optional.empty();
    }

    @Override
    public Optional<HashSet<PhoneExtension>> getTariffSet() {
        return Optional.empty();
    }

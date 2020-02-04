package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.DataFiles;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.exception.FileUtileException;
import by.epam.yakovlev.task.exception.RepositoryException;
import by.epam.yakovlev.task.repository.RepositoryLogic;
import by.epam.yakovlev.task.util.FileUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public enum  RepositoryLogicImplFile implements RepositoryLogic {

    INSTANCE;

    private static FileUtil fileUtil = FileUtil.INSTANCE;
   // private static EntityLogic entityLogic = Factory.INSTANCE.getEntityLogic();

    @Override
    public HashSet<PhoneExtension> getPhoneTariffPartSet() throws RepositoryException {

        ArrayList<String> list = null;

        try {
            list = fileUtil.readFile(DataFiles.PHONE_PART.getFile());
        } catch (FileUtileException e) {
            throw new RepositoryException("Fail access to repository 'phone part'", e);
        }

        HashSet<PhoneExtension> phoneExtensionSet = convertToPhonePartSet(list);

        return phoneExtensionSet;
    }

    @Override
    public boolean addPhoneTariffPart(Optional<PhoneExtension> part) {


        return false;
    }

    @Override
    public boolean removePhoneTariffPart(Optional<PhoneExtension> part) {
        return false;
    }

    @Override
    public Optional<PhoneExtension> findByName(String name) {
        return Optional.empty();
    }

    private HashSet<PhoneExtension> convertToPhonePartSet(ArrayList<String> list) throws RepositoryException {

        HashSet<PhoneExtension> set = new HashSet<PhoneExtension>();

        /*for (String s : list){
            try {
                //set.add(entityLogic.createPhoneTariffPart(s));
            } catch (EntityMakingException e) {
                //throw new RepositoryException("Fail create of 'phone tariff part'", e);
                //log
            }
        }*/

        return set;
    }
}

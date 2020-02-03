package by.epam.yakovlev.task.repository.impl;

import by.epam.yakovlev.task.Factory;
import by.epam.yakovlev.task.data.DataFiles;
import by.epam.yakovlev.task.entity.PhoneTariffPart;
import by.epam.yakovlev.task.entity_logic.EntityLogic;
import by.epam.yakovlev.task.exception.EntityMakingException;
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
    private static EntityLogic entityLogic = Factory.INSTANCE.getEntityLogic();

    @Override
    public HashSet<PhoneTariffPart> getPhoneTariffPartSet() throws RepositoryException {

        ArrayList<String> list = null;

        try {
            list = fileUtil.readFile(DataFiles.PHONE_PART.getFile());
        } catch (FileUtileException e) {
            throw new RepositoryException("Fail access to repository 'phone part'", e);
        }

        HashSet<PhoneTariffPart> phoneTariffPartSet = convertToPhonePartSet(list);

        return phoneTariffPartSet;
    }

    @Override
    public boolean addPhoneTariffPart(Optional<PhoneTariffPart> part) {


        return false;
    }

    @Override
    public boolean removePhoneTariffPart(Optional<PhoneTariffPart> part) {
        return false;
    }

    @Override
    public Optional<PhoneTariffPart> findByName(String name) {
        return Optional.empty();
    }

    private HashSet<PhoneTariffPart> convertToPhonePartSet(ArrayList<String> list) throws RepositoryException {

        HashSet<PhoneTariffPart> set = new HashSet<PhoneTariffPart>();

        for (String s : list){
            try {
                set.add(entityLogic.createPhoneTariffPart(s));
            } catch (EntityMakingException e) {
                //throw new RepositoryException("Fail create of 'phone tariff part'", e);
                //log
            }
        }

        return set;
    }
}

package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.PhoneTariffPart;
import by.epam.yakovlev.task.exception.RepositoryException;

import java.util.HashSet;
import java.util.Optional;

public interface RepositoryLogic {

    HashSet<PhoneTariffPart> getPhoneTariffPartSet() throws RepositoryException;
    boolean addPhoneTariffPart(Optional<PhoneTariffPart> part);
    boolean removePhoneTariffPart(Optional<PhoneTariffPart> part);
    //boolean savePhoneTariffPartSet(Optional<HashSet<PhoneTariffPart>> set);
    Optional<PhoneTariffPart> findByName(String name);
}

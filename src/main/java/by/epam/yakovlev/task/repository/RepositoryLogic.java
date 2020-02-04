package by.epam.yakovlev.task.repository;

import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.exception.RepositoryException;

import java.util.HashSet;
import java.util.Optional;

public interface RepositoryLogic {

    HashSet<PhoneExtension> getPhoneTariffPartSet() throws RepositoryException;
    boolean addPhoneTariffPart(Optional<PhoneExtension> part);
    boolean removePhoneTariffPart(Optional<PhoneExtension> part);
    //boolean savePhoneTariffPartSet(Optional<HashSet<PhoneExtension>> set);
    Optional<PhoneExtension> findByName(String name);
}

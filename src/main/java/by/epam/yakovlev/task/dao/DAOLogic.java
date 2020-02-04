package by.epam.yakovlev.task.dao;

import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.exception.DAOException;

import java.util.HashSet;
import java.util.Optional;

public interface DAOLogic {

    Optional<HashSet<PhoneExtension>> getPhoneTariffPartSet() throws DAOException;
    Optional<HashSet<PhoneExtension>> getInternetTariffPartSet();
    Optional<HashSet<PhoneExtension>> getMobilPhoneTariffSet();
    Optional<HashSet<PhoneExtension>> getInternetTariffSet();
    Optional<HashSet<PhoneExtension>> getSmartPhoneTarifSet();
}

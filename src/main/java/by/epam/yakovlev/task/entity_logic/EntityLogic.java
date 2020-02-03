package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.entity.AbstractTariff;
import by.epam.yakovlev.task.entity.Customer;
import by.epam.yakovlev.task.entity.InternetTariffPart;
import by.epam.yakovlev.task.entity.PhoneTariffPart;
import by.epam.yakovlev.task.exception.EntityMakingException;

import java.util.Optional;

public interface EntityLogic {

    Optional<AbstractTariff> getTariff(String tariffName,
                                       Double monthlyFee,
                                       Optional<PhoneTariffPart> phoneTariffPart,
                                       Optional<InternetTariffPart> internetTariffPart) throws EntityMakingException;

    Optional<Customer> getCustomer(String firstName, String lastName, String passport);

    Optional<String> phoneTariffPartToString(Optional<PhoneTariffPart> phoneTariffPart);

    InternetTariffPart createInternetTariffPart(String string) throws EntityMakingException;
    PhoneTariffPart createPhoneTariffPart(String string) throws EntityMakingException;
}

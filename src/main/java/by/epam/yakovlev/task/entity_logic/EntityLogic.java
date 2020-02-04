package by.epam.yakovlev.task.entity_logic;

import by.epam.yakovlev.task.entity.AbstractTariff;
import by.epam.yakovlev.task.entity.Customer;
import by.epam.yakovlev.task.entity.InternetExtension;
import by.epam.yakovlev.task.entity.PhoneExtension;
import by.epam.yakovlev.task.exception.EntityMakingException;

import java.util.Optional;

public interface EntityLogic {

    Optional<AbstractTariff> getTariff(String tariffName,
                                       Double monthlyFee,
                                       Optional<PhoneExtension> phoneTariffPart,
                                       Optional<InternetExtension> internetTariffPart) throws EntityMakingException;

    Optional<Customer> getCustomer(String firstName, String lastName, String passport);

    InternetExtension createInternetTariffPart(String string) throws EntityMakingException;
    PhoneExtension createPhoneTariffPart(String string) throws EntityMakingException;
}

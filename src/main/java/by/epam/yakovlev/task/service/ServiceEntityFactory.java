package by.epam.yakovlev.task.service;

import by.epam.yakovlev.task.entity.AbstractTariff;
import by.epam.yakovlev.task.entity.Customer;
import by.epam.yakovlev.task.entity.InternetTariffPart;
import by.epam.yakovlev.task.entity.PhoneTariffPart;

import java.util.Optional;

public interface ServiceEntityFactory {

    Optional<AbstractTariff> getTariff(String tariffName,
                                       Double monthlyFee,
                                       PhoneTariffPart phoneTariffPart,
                                       InternetTariffPart internetTariffPart);

    Optional<Customer> getCustomer(String firstName, String lastName, String passport);
}

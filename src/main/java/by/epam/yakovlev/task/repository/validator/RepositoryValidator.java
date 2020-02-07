package by.epam.yakovlev.task.repository.validator;

import by.epam.yakovlev.task.entity.*;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.HashSet;

public class RepositoryValidator {

    public static final RepositoryValidator INSTANCE = new RepositoryValidator();

    private Logger LOGGER = Logger.getLogger(RepositoryValidator.class);

    private RepositoryValidator() {
    }

    public static RepositoryValidator getINSTANCE() {
        return INSTANCE;
    }

    public boolean isPhoneExtensionValid(MobilProviderCompatibleType anyEntity){

        if (anyEntity == null) {
            LOGGER.debug("isPhoneExtensionValid");
            LOGGER.debug("anyEntity == null");
            return false;
        }
        if (anyEntity.getClass() != PhoneExtension.class) {
            LOGGER.debug("anyEntity.getClass() != PhoneExtension.class");
            return false;
        }

        PhoneExtension phoneExtension = (PhoneExtension)anyEntity;

        if (phoneExtension.getPhoneExtensionName() == null) {
            LOGGER.debug("phoneExtension.getPhoneExtensionName() == null");
            return false;
        }
        if (phoneExtension.getIncomeCallFee() == null ||
                phoneExtension.getIncomeCallFee().compareTo(BigDecimal.valueOf(0.0)) < 0) {
            LOGGER.debug("phoneExtension.getIncomeCallFee() == null ||\n" +
                    "                phoneExtension.getIncomeCallFee().compareTo(BigDecimal.valueOf(0.0)) < 0");
            return false;
        }
        if (phoneExtension.getOutcomeCallFee() == null ||
                phoneExtension.getOutcomeCallFee().compareTo(BigDecimal.valueOf(0.0)) < 0) {
            LOGGER.debug("phoneExtension.getOutcomeCallFee() == null ||\n" +
                    "                phoneExtension.getOutcomeCallFee().compareTo(BigDecimal.valueOf(0.0)) < 0");
            return false;
        }
        if (phoneExtension.getAnyProviderIncludedMinutes()  < 0) {
            LOGGER.debug("phoneExtension.getAnyProviderIncludedMinutes()  < 0");
            return false;
        }
        if (phoneExtension.getInnerProviderIncludedMinutes()  < 0) {
            LOGGER.debug("phoneExtension.getInnerProviderIncludedMinutes()  < 0");
            return false;
        }

        return true;
    }

    public boolean isInternetExtensionValid(MobilProviderCompatibleType anyEntity){

        if (anyEntity == null) {
            LOGGER.debug("isInternetExtensionValid");
            LOGGER.debug("anyEntity == null");
            return false;
        }
        if (anyEntity.getClass() != InternetExtension.class) {
            LOGGER.debug("anyEntity.getClass() != InternetExtension.class");
            return false;
        }

        InternetExtension internetExtension = (InternetExtension)anyEntity;

        if (internetExtension.getInternetExtensionName() == null) {
            LOGGER.debug("internetExtension.getInternetExtensionName() == null");
            return false;
        }
        if (internetExtension.getTrafficFee() == null ||
                internetExtension.getTrafficFee().compareTo(BigDecimal.valueOf(0.0)) < 0) {
            LOGGER.debug("internetExtension.getTrafficFee() == null ||\n" +
                    "                internetExtension.getTrafficFee().compareTo(BigDecimal.valueOf(0.0)) < 0");
            return false;
        }

        if (internetExtension.getIncludedTraffic()  < 0) {
            LOGGER.debug("internetExtension.getIncludedTraffic()  < 0");
            return false;
        }
        if (internetExtension.getTrafficLimit()  < 0) {
            LOGGER.debug("internetExtension.getTrafficLimit()  < 0");
            return false;
        }
        if (internetExtension.getTrafficSpeedLimit()  < 0) {
            LOGGER.debug("internetExtension.getTrafficSpeedLimit()  < 0");
            return false;
        }

        return true;
    }

    public boolean isTariffValid(MobilProviderCompatibleType anyEntity){

        if (anyEntity == null) {
            LOGGER.debug("isTariffValid");
            LOGGER.debug("anyEntity == null");
            return false;
        }
        if (anyEntity.getClass() != Tariff.class) {
            LOGGER.debug("anyEntity.getClass() != Tariff.class");
            return false;
        }

        Tariff tariff = (Tariff) anyEntity;

        if (tariff.getTariffName() == null) {
            LOGGER.debug("tariff.getTariffName() == null");
            return false;
        }
        if (tariff.getMonthlyFee() == null ||
                tariff.getMonthlyFee().compareTo(BigDecimal.valueOf(0.0)) < 0) {
            LOGGER.debug("tariff.getMonthlyFee() == null ||\n" +
                    "                tariff.getMonthlyFee().compareTo(BigDecimal.valueOf(0.0)) < 0");
            return false;
        }
        if (tariff.getExtensionSet() == null){
            LOGGER.debug("tariff.getExtensionSet() == null");
            return false;
        }

        HashSet<TariffExtension> extensions = tariff.getExtensionSet();

        int phoneExtensionCount = 0;
        int internetExtensionCount = 0;

        for (TariffExtension t : extensions){
            if (t.getClass() == PhoneExtension.class){
                phoneExtensionCount++;
            } else if (t.getClass() == InternetExtension.class) {
                internetExtensionCount++;
            }
        }

        if (phoneExtensionCount > 1 ||
        internetExtensionCount > 1) {
            LOGGER.debug("there are more than one tariff extensions of the equal type");
            return false;
        }

        return true;
    }
}

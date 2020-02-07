package by.epam.yakovlev.task.entity_logic.impl;

import by.epam.yakovlev.task.dao.impl.DAOLogicImplFile;
import by.epam.yakovlev.task.entity.*;
import by.epam.yakovlev.task.entity_logic.MobilProviderFactory;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.RepositoryFactory;
import by.epam.yakovlev.task.repository.impl.TariffExtensionTables;
import org.apache.log4j.Logger;

import java.util.jar.Attributes;

public class MobilProviderFactoryImpl implements MobilProviderFactory {

    private static final EntityUtil UTIL = EntityUtil.getInstance();
    private static Logger LOGGER = Logger.getLogger(DAOLogicImplFile.class);
    //private static final  Repository REPOSITORY = RepositoryFactory.getINSTANCE().getREPOSITORY();

    private static final String NAME = "name";
    private static final String MONTHLY_FEE = "monthly-fee";
    private static final String PHONE_EXTENSION_NAME = "phone-extension-name";
    private static final String INTERNET_EXTENSION_NAME = "internet-extension-name";
    private static final String ANY_PROVIDER_INCLUDED_MINUTES = "any-provider-included-minutes";
    private static final String INCOME_CALL_FEE = "income-call-fee";
    private static final String OUTCOME_CALL_FEE = "outcome-call-fee";
    private static final String INNER_PROVIDER_INCLUDED_MINUTES = "inner-provider-included-minutes";
    private static final String INCLUDED_TRAFFIC = "included-traffic";
    private static final String TRAFFIC_LIMIT = "traffic-limit";
    private static final String TRAFFIC_SPEED_LIMIT = "traffic-speed-limit";
    private static final String TRAFFIC_FEE = "traffic-fee";

    @Override
    public MobilProviderCompatibleType applicationEntityFactory(String string, EntityTypeEnum type) {

        if (string == null || type == null){
            return null;
        }

        MobilProviderCompatibleType res = null;
        Attributes typeAttributes = UTIL.ParseStringToAttributes(string);

        switch (type){
            case TARIFF: {

                res = new Tariff();
                Tariff tariff = (Tariff)res;

                tariff.setTariffName(typeAttributes.getValue(NAME));
                tariff.setMonthlyFee(UTIL.stringToPositiveBigDecimal(typeAttributes.getValue(MONTHLY_FEE)));

                /*if  (typeAttributes.containsKey(TariffExtensionTables.PHONE.name())){
                    tariff.getExtensionSet().add(REPOSITORY.getExtension(TariffExtensionTables.PHONE,
                            typeAttributes.getValue(TariffExtensionTables.PHONE.name())));
                }

                if  (typeAttributes.containsKey(TariffExtensionTables.INTERNET.name())){
                    tariff.getExtensionSet().add(REPOSITORY.getExtension(TariffExtensionTables.INTERNET,
                            typeAttributes.getValue(TariffExtensionTables.INTERNET.name())));
                }*/

                break;
            }
            case TARIFF_PHONE_EXTENSION: {

                res = new PhoneExtension();
                PhoneExtension phoneExtension = (PhoneExtension)res;

                phoneExtension.setPhoneExtensionName(typeAttributes.getValue(NAME));
                phoneExtension.setAnyProviderIncludedMinutes(
                        UTIL.stringToPositiveInt(typeAttributes.getValue(ANY_PROVIDER_INCLUDED_MINUTES)));
                phoneExtension.setIncomeCallFee(
                        UTIL.stringToPositiveBigDecimal(typeAttributes.getValue(INCOME_CALL_FEE)));
                phoneExtension.setOutcomeCallFee(
                        UTIL.stringToPositiveBigDecimal(typeAttributes.getValue(OUTCOME_CALL_FEE)));
                phoneExtension.setInnerProviderIncludedMinutes(
                        UTIL.stringToPositiveInt(typeAttributes.getValue(INNER_PROVIDER_INCLUDED_MINUTES)));
                break;
            }
            case TARIFF_INTERNET_EXTENSION: {

                res = new InternetExtension();
                InternetExtension internetExtension = (InternetExtension) res;

                internetExtension.setInternetExtensionName(typeAttributes.getValue(NAME));
                internetExtension.setIncludedTraffic(
                        UTIL.stringToPositiveDouble(typeAttributes.getValue(INCLUDED_TRAFFIC)));
                internetExtension.setTrafficLimit(
                        UTIL.stringToPositiveDouble(typeAttributes.getValue(TRAFFIC_LIMIT)));
                internetExtension.setTrafficSpeedLimit(
                        UTIL.stringToPositiveDouble(typeAttributes.getValue(TRAFFIC_SPEED_LIMIT)));
                internetExtension.setTrafficFee(
                        UTIL.stringToPositiveBigDecimal(typeAttributes.getValue(TRAFFIC_FEE)));
                break;
            }
            case CUSTOMER:{

                break;
            }
            case SIM_CARD:{

            }
        }

        return res;
    }
}

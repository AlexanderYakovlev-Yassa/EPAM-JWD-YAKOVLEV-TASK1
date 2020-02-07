package by.epam.yakovlev.task.repository.specification;

import by.epam.yakovlev.task.entity_logic.impl.EntityUtil;
import by.epam.yakovlev.task.repository.Repository;
import by.epam.yakovlev.task.repository.RepositoryFactory;
import by.epam.yakovlev.task.repository.Specification;

import java.util.jar.Attributes;

public class findPhoneTariffExtension implements Specification {

    private static final EntityUtil UTIL = EntityUtil.getInstance();
    private static final Repository REPOSITORY = RepositoryFactory.getINSTANCE().getREPOSITORY();

    private String phoneTariffExtensionName;


    @Override
    public boolean isMatched(String requestParameters) {

        Attributes parameters = UTIL.ParseStringToAttributes(requestParameters);

        String phoneTariffExtension = parameters.getValue(SpecificationParameters.TABLE_NAME.name());
        String value = parameters.getValue(SpecificationParameters.VALUE.name());


        return false;
    }
}

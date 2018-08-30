package be.axxes.consultants;

import be.axxes.consultants.model.Consultant;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.slf4j.LoggerFactory.getLogger;

@Component("beforeCreateConsultantValidator")
public class CreateConsultantValidator implements Validator {
    private static final Logger LOGGER = getLogger(CreateConsultantValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Consultant.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Consultant user = (Consultant) obj;
        if (checkInputString(user.getFirstName())) {
            LOGGER.debug("validation error, firstName invalid");
            errors.rejectValue("firstName", "firstName.empty");
        }

        if (checkInputString(user.getLastName())) {
            LOGGER.debug("validation error, lastName invalid");
            errors.rejectValue("lastName", "lastName.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}

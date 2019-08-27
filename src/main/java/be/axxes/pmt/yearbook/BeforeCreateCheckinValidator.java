package be.axxes.pmt.yearbook;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.slf4j.LoggerFactory.getLogger;

@Component("beforeCreateCheckinValidator")
public class BeforeCreateCheckinValidator implements Validator {
    private static final Logger LOGGER = getLogger(BeforeCreateCheckinValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Checkin.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Checkin user = (Checkin) obj;
        if (!user.getUser().contains("@axxes.com")) {
            LOGGER.debug("validation error, user should be an axxes email addres");
            errors.rejectValue("user", "user.email.invalid");
        }

        if (user.getQuarter() < 1 && user.getQuarter() > 5) {
            LOGGER.debug("validation error, quarter must be a value between 1-4");
            errors.rejectValue("quarter", "quarter.invalid");
        }
        if (user.getYear() < 2010 && user.getYear() > 2999) {
            LOGGER.debug("validation error, year should be between 2010 and 2999");
            errors.rejectValue("year", "year.invalid");
        }
    }

}

package mar.faszom.kivan.web.validation;

import mar.faszom.kivan.domain.Address;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 *  Fehér Zolitól lopott kód
 *  
 *  MAJD NÉZD ÁT PARASZT
 */


public class AddressValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "required", "Field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "required", "Field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "required", "Field is required.");
        
        Address address = (Address) target;
        String zip = address.getZip();
        
        rejectIfNotANumber(errors, "zip", zip);
        rejectIfLongerThan(errors, "zip", zip, 4);
        
    }

    // TODO: általános util-ba kiemelhetõ
    private void rejectIfLongerThan(Errors errors, String name, String value, int maxLength)
    {
        if (value != null  && value.isEmpty() == false && value.length() > maxLength)
        {
            errors.rejectValue(name,  "longerthanmaxlength", "Longer than "+maxLength+" characters.");
        }
    }

    // TODO: általános util-ba kiemelhetõ
    private void rejectIfNotANumber(Errors errors, String name, String value)
    {
        if (value != null && value.isEmpty() == false)
        {
            try
            {
                Integer.parseInt(value);
            }
            catch (NumberFormatException nfe)
            {
                errors.rejectValue(name, "notanumber", "Not a number.");
            }
        }
    }
}


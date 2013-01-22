package mar.faszom.kivan.web.validation;

import mar.faszom.kivan.domain.Address;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 *  Feh�r Zolit�l lopott k�d
 *  
 *  MAJD N�ZD �T PARASZT
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

    // TODO: �ltal�nos util-ba kiemelhet�
    private void rejectIfLongerThan(Errors errors, String name, String value, int maxLength)
    {
        if (value != null  && value.isEmpty() == false && value.length() > maxLength)
        {
            errors.rejectValue(name,  "longerthanmaxlength", "Longer than "+maxLength+" characters.");
        }
    }

    // TODO: �ltal�nos util-ba kiemelhet�
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


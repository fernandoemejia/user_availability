package com.IntertecIntl.availableuser.validator;
import com.IntertecIntl.availableuser.model.RestrictedWord;
import com.IntertecIntl.availableuser.service.RestrictedWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RestrictedWordValidator implements Validator {

	   @Autowired
	    private RestrictedWordService restrictedWordService;
	 public boolean supports(Class<?> aClass) {
	        return RestrictedWord.class.equals(aClass);
	    }

	@Override
	public void validate(Object o, Errors errors) {
		RestrictedWord restrictedWord = (RestrictedWord) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
	        if (restrictedWord.getName().length() < 3 || restrictedWord.getName().length() > 32) {
	            errors.rejectValue("name", "Size.restrictedWordForm.name");
	        }
	        if (restrictedWordService.findByName(restrictedWord.getName()) != null) {
	            errors.rejectValue("name", "Duplicate.restrictedWordForm.name");
	        }

		
	}

}

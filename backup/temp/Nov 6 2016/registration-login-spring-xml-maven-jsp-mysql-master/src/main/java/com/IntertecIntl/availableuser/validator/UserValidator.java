package com.IntertecIntl.availableuser.validator;

import java.util.ArrayList;
import java.util.List;

import com.IntertecIntl.availableuser.model.RestrictedWord;
import com.IntertecIntl.availableuser.model.User;
import com.IntertecIntl.availableuser.service.RestrictedWordService;
import com.IntertecIntl.availableuser.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Autowired
    private RestrictedWordService restrictedWordService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        List<String> restrictedWordList= new ArrayList<String>();
        List<RestrictedWord> restrictedWords= restrictedWordService.findAll();
        String forbiddenWords="";
        Boolean isRestricted=false;
        for(RestrictedWord word: restrictedWords){
        	restrictedWordList.add(word.getName());
        	
        	forbiddenWords= forbiddenWords+word.getName() +" ,";
        }
        
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username", "This username is already taken. \n Perhaps you may want to consider one of the following \n"
            + "\n"+ user.getUsername()+"1"+","+user.getUsername()+"2,\n"
            + user.getUsername()+"3"+","+user.getUsername()+"4, \n"
            + user.getUsername()+"5"+","+user.getUsername()+"6,\n"
            + user.getUsername()+"7"+","+user.getUsername()+"8,\n"
            + user.getUsername()+"9"+","+user.getUsername()+"10,\n"
            + user.getUsername()+"11"+","+user.getUsername()+"12,\n"
            + user.getUsername()+"13"+","+user.getUsername()+"14\n"
           
            		
            		
            		
            );
        }
        
        for (int index=0; index<restrictedWordList.size();index++){
        	if(user.getUsername().contains(restrictedWordList.get(index)))
        		isRestricted=true;
        }
        
        
        if (isRestricted){
        	errors.rejectValue( "username","Forbidden.restrictedWordForm.name","Please don't use usernames that contain forbidden words such as the ones below \n."+forbiddenWords);
        }
       
    }
}

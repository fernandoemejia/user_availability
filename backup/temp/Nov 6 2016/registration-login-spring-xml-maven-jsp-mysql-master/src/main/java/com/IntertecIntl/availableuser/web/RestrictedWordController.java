package com.IntertecIntl.availableuser.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.IntertecIntl.availableuser.model.RestrictedWord;
import com.IntertecIntl.availableuser.service.RestrictedWordService;
import com.IntertecIntl.availableuser.validator.RestrictedWordValidator;

@Controller
public class RestrictedWordController {
    @Autowired
    private RestrictedWordService restrictedWordService;

    @Autowired
    private RestrictedWordValidator restrictedWordValidator;

    @RequestMapping(value = "/restrictedWordRegistration", method = RequestMethod.GET)
    public String restrictedWordRegistration(Model model) {
        model.addAttribute("restrictedWordForm", new RestrictedWord());

        return "restrictedWordRegistration";
    }

    @RequestMapping(value = "/restrictedWordRegistration", method = RequestMethod.POST)
    public String restrictedWordRegistration(@ModelAttribute("restrictedWordForm") RestrictedWord restrictedWordForm, BindingResult bindingResult, Model model) {
        restrictedWordValidator.validate(restrictedWordForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "restrictedWordRegistration";
        }

        restrictedWordService.save(restrictedWordForm);

       

        return "redirect:/welcome";
    }

    
    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "login";
    }*/
}

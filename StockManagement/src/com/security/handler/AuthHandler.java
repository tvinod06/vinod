package com.security.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.constant.Constants;

@Controller
public class AuthHandler {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView model = new ModelAndView(Constants.CUSTOM_LOGIN);
        return model;
    }
	
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView loginerror() {
    	ModelAndView model = new ModelAndView(Constants.ACCESS_DENIED);
        model.addObject("error", "true");
        return model;
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
    	ModelAndView model = new ModelAndView(Constants.LOGOUT);
        return model;
    }
}

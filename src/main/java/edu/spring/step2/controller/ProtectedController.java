package edu.spring.step2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/protected")
public class ProtectedController {

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView protectedPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security  Hello World Tutorial");
        model.addObject("message", "This is protected page - Only for super Admin Users!");
        model.setViewName("protected");
        return model;
    }
}

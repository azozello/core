package com.blog.controllers;

import com.blog.models.Entities.ROLE;
import com.blog.models.Entities.User;
import com.blog.models.Entities.UserForm;
import com.blog.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
    public String create(){
        return "users/userform";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String check(UserForm userForm, Model model){
        if (userForm.getPasswordOne().equals(userForm.getPasswordTwo())){
            User user = new User();
            user.setEmail(userForm.getLogin());
            user.setPassword(userForm.getPasswordOne());
            user.setRole(ROLE.USER);
            userService.insertUser(user);
            model.addAttribute("created",1);
            return "redirect:/login";
        }
        return "redirect:/login";
    }
}

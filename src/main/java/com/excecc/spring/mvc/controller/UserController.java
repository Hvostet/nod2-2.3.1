package com.excecc.spring.mvc.controller;
import com.excecc.spring.mvc.entity.User;
import com.excecc.spring.mvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //===========================================================================//

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }



    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    //===========================================================================//

//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "new";
//    }

    @GetMapping(value = "/new")
    public String makeUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }



    @PostMapping(value ="/create")
    public String createUser(@ModelAttribute("user")  User user) {
            userService.saveUser(user);
            return "redirect:/users";
    }

    //============================================================================//

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }


    //============================================================================//


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        System.out.println("Click delete");
        User user = userService.getUser(id);
        userService.removeUser(user);

        return "redirect:/users";
    }
}

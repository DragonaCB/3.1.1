package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/index";
    }

    @GetMapping("/show")
    public String getUserById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/show";
    }

    @GetMapping("/new")
    public String getNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String getEditUserForm(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user.getId(), user);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}

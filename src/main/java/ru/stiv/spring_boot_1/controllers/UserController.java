package myappweb.controllers;

import myappweb.models.User;
import myappweb.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class UserController {

    private final ServiceUser serviceUser;
    @Autowired()
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping()
    public String snowDbUsers(Model model) {
        model.addAttribute("users", serviceUser.userShow());
        return "people/show";
    }
    @GetMapping("/add")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "people/add";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/add";
        serviceUser.add(user);
        return "redirect:/people";
    }
    @GetMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute(serviceUser.findUser(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/edit";
        serviceUser.update(user);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        serviceUser.delete(id);
        return "redirect:/people";
    }
}

package spring_mvc_hibernate.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_mvc_hibernate.app.entity.User;
import spring_mvc_hibernate.app.service.UserService;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "allUsers";
    }

    @GetMapping("/new")
    public String newUser(@RequestParam(name = "id", required = false) Integer id, Model model) {
        verifyUserId(id, model);
        return "newUser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    private void verifyUserId(Integer id, Model model) {
        if (id != null) {
            model.addAttribute("user", userService.findById(id));
        } else {
            model.addAttribute("user", new User());
        }
    }
}

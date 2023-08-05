package com.axsos.javaexam.controllers;

import com.axsos.javaexam.models.Celebrity;
import com.axsos.javaexam.models.User;
import com.axsos.javaexam.models.LoginUser;
import com.axsos.javaexam.services.CelebrityService;
import com.axsos.javaexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userServ;
    private final CelebrityService celebrityService;

    public HomeController(UserService userServ, CelebrityService celebrityService) {
        this.userServ = userServ;
        this.celebrityService = celebrityService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            return "redirect:/home";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {
        User regUser = userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        session.setAttribute("user_id", regUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User logUser = userServ.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("user_id", logUser.getId());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String success(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userServ.findUserById(userId);
            List<Celebrity> allcelb = celebrityService.allCelebrities();
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("allcelb", allcelb);
            return "success.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/clebrities/new")
    public String addCelebrity(Model model, HttpSession session, @ModelAttribute("celebrity") Celebrity Celebrity) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User user = userServ.findUserById(userId);
            model.addAttribute("user", user);
            return "index.jsp";
        }
        return "redirect:/";

    }

    @PostMapping("/clebrities/new")
    public String createCelebrity(@Valid @ModelAttribute("celebrity") Celebrity celebrity, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        }
        celebrityService.createCelebrity(celebrity);
        return "redirect:/home";
    }


    @GetMapping("/celebrities/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
        Celebrity celebrity = celebrityService.findCelebrityById(id);
        Long userId = (Long) session.getAttribute("user_id");
        if (userId == null || userId != celebrity.getPageManager().getId()) {
            return "redirect:/";
        }
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("userId", userId);
        model.addAttribute("celebrity", celebrity);
        return "edit.jsp";
    }

    @PostMapping("/celebrities/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("celebrity") Celebrity celebrity, BindingResult result, HttpSession session) {
        if (session.getAttribute("user_id") == null || session.getAttribute("user_id") != celebrity.getPageManager().getId()) {
            return "redirect:/";
        }
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        celebrity.setId(id);
        celebrityService.updateCelebrity(celebrity);
        return "redirect:/home";
    }


    @GetMapping("/celeb/{id}")
    public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
        Celebrity celebritty = celebrityService.findCelebrityById(id);
        Long userId = (Long) session.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userServ.findUserById(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("celebrityy", celebritty);
        return "showcelb.jsp";


    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        celebrityService.deleteCelebrity(id);
        return "redirect:/home";
    }





















}

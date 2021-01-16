package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.enterprise.inject.Model;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>User Page</h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>Admin</h1>";
    }

}

package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "<h1>Main</h1>";
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

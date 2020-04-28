package com.anand.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    // http://localhost:8080/
    // Will auto redirected to http://localhost:8080/login.
    // To sign in, enter
    // Username: user
    // Password: 430cdbac-0ddb-414a-8457-12bbc62e3822 (Go to your Spring Boot log and find the line: "Using generated security password:......"
    // When you set your username and password in application.properties file, you enter your own username and password.
    // When using proper file like create a class called com.anand.security.com.anand.security.SecurityConfiguration extends WebSecurityConfigurerAdapter.
    // In memory authentication, you also enter your own username and password.
    // You can log out, by using http://localhost:8080/logout. It will ask you to confirm logout. Click yes and you're logged out.
    @GetMapping("/")
    public String home() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>Welcome User</h1>";
    }
    @GetMapping("/admin")
    public String admin() {
        return "<h1>Welcome Admin</h1>";
    }
}

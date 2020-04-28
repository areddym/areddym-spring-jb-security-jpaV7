package com.anand.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Create a class and extends WebSecurityConfigurerAdapter
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }

    // You can create this bean anywhere. And Spring Security will auto using yours as default PasswordEncoder
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // This NoOpPasswordEncoder object is deprecated is not because it's expired, but it's the Spring Security team
        // don't want to recommend you to use this type of password encoder in your application.
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        // Remove super call
        // super.configure(http);
        // Ant matcher is an important concept, like regex
        // In antPatterns, a few that you need to know:
        // If you put / , it will read any API that has /
        // If you put /** , it will read any API that has / but accepting anything that behinds it, no matter how many slashes behind it. For example:
        // /foo , /example/adaw/rghrog
        // REMEMBER*******the longest URLs are put at the top, the shortest ones are put at the bottom**********
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN") // Only admin can access
                .antMatchers("/user").hasAnyRole("USER", "ADMIN") // User and Admin can access
                .antMatchers("/").permitAll() // Allow everyone to use this
//                .antMatchers("/**").hasAnyRole("USER", "ADMIN")
                // .hasRole("USER")
                .and()
                .formLogin();

        // formLogin() is the popular choice. Use a form to login.
    }

}
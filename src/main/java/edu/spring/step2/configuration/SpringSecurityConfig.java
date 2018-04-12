package edu.spring.step2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    PasswordEncoder encoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("sadmin").password(encoder.encode("sadmin")).roles("SUPERADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").hasAnyRole("ADMIN", "SUPERADMIN" )
                .antMatchers("/protected/**").hasAnyRole("SUPERADMIN")
                .and().formLogin().defaultSuccessUrl("/", false);
    }
}

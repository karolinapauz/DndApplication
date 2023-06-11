package com.dndappbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource; //cia springas supras automatiskai, kad jungtis prie musu sukonfiguruotos DB.

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //nurodome objekta, kuris bus atsakingas uz slaptazodzio uzkodavima (encdonima)
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT firstname, password, enabled from players where firstname = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.firstname, r.roles " +
                                "FROM role r, players u " +
                                "WHERE u.firstname = ? " +
                                "AND u.id = r.id"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.httpBasic(); //bus prasoma ivesti login/password narsykles pop upe
//        http.formLogin(); //bus pateikta defaultine springo logino forma.

        http
                .authorizeRequests()
              //  .antMatchers("/").permitAll()
                .antMatchers("/game/**").hasAuthority("ADMIN")
                .antMatchers("/user/userinfo/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/user/**").hasAuthority("ADMIN");
//                .antMatchers("/**").permitAll()

    }


}
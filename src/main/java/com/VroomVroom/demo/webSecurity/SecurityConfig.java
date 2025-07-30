package com.VroomVroom.demo.webSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/app/AdminPage/**").hasRole("ADMIN")
                        .anyRequest().permitAll())
                .formLogin(withDefaults())
                .logout(withDefaults()).csrf(AbstractHttpConfigurer::disable) // disabled for simplicity
                .formLogin(formLogin -> formLogin.loginPage("/login")
                        .defaultSuccessUrl("/Startseite"))
                .logout(logout -> logout.logoutSuccessUrl("/login"));
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        //Benutzer "admin1": Passwort ist "admin1Pass" :)
        UserDetails admin1 = User.withUsername("admin1")
                .password(passwordEncoder().encode("admin1Pass"))
                .roles("ADMIN")
                .build();
        UserDetails admin2 = User.withUsername("Martin Müller")
                .password(passwordEncoder().encode("1337"))
                .roles("ADMIN")
                .build();
        UserDetails admin3 = User.withUsername("admin3")
                .password(passwordEncoder().encode("admin3Pass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin1, admin2, admin3);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

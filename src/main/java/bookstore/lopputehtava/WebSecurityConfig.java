package bookstore.lopputehtava;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import bookstore.lopputehtava.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
        new AntPathRequestMatcher("/api/books"),
        new AntPathRequestMatcher("/h2-console"),
        new AntPathRequestMatcher("/index")};

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(antMatcher("/css/**")).permitAll()
            .requestMatchers(WHITE_LIST_URLS).permitAll()
            .anyRequest().authenticated()
        )
        .headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions
            .disable())
        )
        .formLogin(formlogin -> formlogin
            //.loginPage("/login") TODO: login.html
            .defaultSuccessUrl("/index", true)
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll()
        )
        .csrf(csrf -> csrf.disable()); //TODO: remove for production
        return http.build();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}

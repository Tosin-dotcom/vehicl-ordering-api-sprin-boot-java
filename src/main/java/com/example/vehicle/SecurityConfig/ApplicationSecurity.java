package com.example.vehicle.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.vehicle.SecurityConfig.ApplicationUserRole.*;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity {

    private final PasswordEncoder passwordEncoder;
    // private final AuthEntryPointJwt unauthorizedHandler;
    // AuthEntryPointJwt unauthorizedHandler

    @Autowired
    public ApplicationSecurity(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        // this.unauthorizedHandler = unauthorizedHandler;
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http
    // .csrf().disable()
    // .sessionManagement().sessionCreationPolicy(STATELESS).and()
    // .authorizeRequests()
    // // .antMatchers("/", "index", "/css/*", "/js/*")
    // // .permitAll()
    // // .antMatchers("/api/**").hasRole(ADMIN.name())
    // .anyRequest()
    // .authenticated()
    // .and()
    // .httpBasic();
    // http.authenticationProvider(authenticationProvider());

    // http.addFilterBefore(authenticationJwtTokenFilter(),
    // UsernamePasswordAuthenticationFilter.class);
    // return http.build();
    // }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        // .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        // .addFilter(new JwtUsernameAndPasswordAuthenticationFilter())
        // .authorizeRequests().antMatchers("/api/v1/auth/**",
        // "/swagger-ui/**").permitAll()
        // .antMatchers("/api/test/**").permitAll()
        // .anyRequest().authenticated();

        // http.authenticationProvider(authenticationProvider());

        // http.addFilterBefore(authenticationJwtTokenFilter(),
        // UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails tosin = User.builder()
                .username("Tosin")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name()) // ROLE_ADMIN
                .build();
        UserDetails tosin2 = User.builder()
                .username("Tosin2")
                .password(passwordEncoder.encode("password123"))
                .roles(VISITOR.name()) // ROLE_VISITOR
                .build();

        return new InMemoryUserDetailsManager(
                tosin,
                tosin2);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
        return (web) -> web.ignoring().antMatchers("/", "index", "/css/*", "/js/*");

    }
}

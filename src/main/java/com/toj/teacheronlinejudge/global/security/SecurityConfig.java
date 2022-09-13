package com.toj.teacheronlinejudge.global.security;

import com.toj.teacheronlinejudge.global.security.auth.AuthDetailsService;
import com.toj.teacheronlinejudge.global.security.jwt.JwtTokenProvider;
import com.toj.teacheronlinejudge.global.security.jwt.JwtValidateService;
import com.toj.teacheronlinejudge.global.security.jwt.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthDetailsService authDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtValidateService jwtValidateService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated()
                ;

        http
                .addFilterBefore(new JwtAuthenticationFilter(authDetailsService, jwtTokenProvider, jwtValidateService)
                        , UsernamePasswordAuthenticationFilter.class)
                ;
    }
}

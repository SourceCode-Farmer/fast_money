package com.fastmoney.fast_money.security;

import com.fastmoney.fast_money.config.CorsConfigurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Autowired
    MyInvocationSecurityMetadataSource myInvocationSecurityMetadataSource;

    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;

    @Autowired
    CorsConfigurer corsConfigurer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.addFilter(filterSecurityInterceptor())
        .authorizeRequests().anyRequest().authenticated()
                .antMatchers("/public/**").permitAll()
                .and().formLogin().successHandler(myAuthenticationSuccessHandler).permitAll()
                .and().logout().permitAll()
                .and().cors()
                .and().headers().frameOptions().disable()
                .and().csrf().disable();
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");
        http.addFilterBefore(myFilterSecurityInterceptor,FilterSecurityInterceptor.class);
    }
  
    
    @Bean
     public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor(){
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setSecurityMetadataSource(myInvocationSecurityMetadataSource);
        filterSecurityInterceptor.setAccessDecisionManager(myAccessDecisionManager);
        return filterSecurityInterceptor;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }
}

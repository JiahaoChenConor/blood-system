package com.elec5619.bloodsystem.security;

import com.elec5619.bloodsystem.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AccountDetailService accountDetailService;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     AccountDetailService accountDetailService,
                                     CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler){
        this.passwordEncoder = passwordEncoder;
        this.accountDetailService = accountDetailService;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()

                // permit index page for all users(non-user)
                .antMatchers("/", "index", "/css/*", "/js/*", "/img/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers( "/api/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()

                // login settings
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email").passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
//                .and()
//                .rememberMe()
//                // https://stackoverflow.com/questions/46421185/remember-me-not-working-throws-java-lang-illegalstateexception-userdetailsse
//
//
//                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
//                .key("3231kjhgh312yy213gGGGKKSA")// for md5
//                .userDetailsService(accountDetailService) ;  // TODO: why it didn't pick the default from DaoAuthenticationProvider?
                .and()

                // log out settings
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/index");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(accountDetailService);
        return provider;
    }
}

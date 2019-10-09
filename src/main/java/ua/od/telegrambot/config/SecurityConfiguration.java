package ua.od.telegrambot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    
    @Autowired
    private CustomUserDetails userDetails;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.headers().frameOptions().disable(); // connect to H2 db via http://localhost:8080/h2
		http.
			
			authorizeRequests().antMatchers("/js/**","/images/**","/","/home", "/library", "/h2**", "/registration", "/register").permitAll().
			antMatchers("/admin/**").hasRole("ADMIN").
			antMatchers("/user/**").hasRole("USER").
			anyRequest().authenticated().					
			and().
			formLogin().permitAll().
			and()
			.logout().
			logoutUrl("/perform_logout").
			logoutSuccessUrl("/").
			invalidateHttpSession(true).
			deleteCookies("JSESSIONID");
			
	}
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetails);
        auth.setPasswordEncoder(passwordEncoder());
        
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
    
        auth.authenticationProvider(authenticationProvider());
    }
}

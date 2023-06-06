package az.atl.demosecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/security/login")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/security/test")
                .authenticated()
                .and()
                .authorizeRequests().antMatchers("/security/admin").hasAnyRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/security/user").hasAnyRole("USER")
                        .and()
                .authorizeRequests().antMatchers(HttpMethod.POST,"/security/post").hasAnyRole("ADMIN");


        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }
}

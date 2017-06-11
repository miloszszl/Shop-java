package security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by przemek on 2017-04-09.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/image/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/products/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/products/categories/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users/").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/users/").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/orders/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/products/categories/").permitAll()          //test only
                .antMatchers(HttpMethod.GET, "/city/").permitAll()                             //test only
                .antMatchers(HttpMethod.GET, "/api/users/").permitAll()                        //test only
                .antMatchers(HttpMethod.GET, "/api/user/{id}").permitAll()                     //test only
                .antMatchers(HttpMethod.PUT, "/api/user/{id}").permitAll()                     //test only
                .antMatchers(HttpMethod.DELETE, "/api/user/{id}").permitAll()                  //test only
                .antMatchers(HttpMethod.GET, "/api/users/{login}").permitAll()              //test only
                .antMatchers("/").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                // We filter the api/login requests
                .addFilterBefore(new JWTLoginFilter("/api/authenticate", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}

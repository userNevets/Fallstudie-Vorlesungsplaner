package dhbw.vs.uniplaner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/**"); //write your resource directory name
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
        ;
    }

//    this is for the admin
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //super.configure(http);
//
//        http
//                .authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*")
//                .hasRole("ROLE_ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //super.configure(http);
//
//        http
//                .authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*", "/admin").hasRole("ROLE_ADMIN")
//                .antMatchers("/student").hasRole("ROLE_STUDENT")
//                .antMatchers("/dozent").hasRole("ROLE_DOZENT")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails stevenUser = User.builder()
                .username("steven")
                .password(passwordEncoder.encode("password"))
                .roles("Student") // ROLE_STUDENT
                .build()
        ;

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin000"))
                .roles("Admin") // ROLE_ADMIN
                .build()
        ;

        return new InMemoryUserDetailsManager(
                stevenUser,
                adminUser
        );
    }
}

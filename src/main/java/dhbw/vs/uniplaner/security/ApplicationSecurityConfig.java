package dhbw.vs.uniplaner.security;

import dhbw.vs.uniplaner.service.Custom_UniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new Custom_UniUserService();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    //private final PasswordEncoder passwordEncoder;

    //@Autowired
/*    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }*/

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/**"); //write your resource directory name
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
/*               .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**", "/Kalender/**").permitAll()
                .antMatchers("/main").permitAll()
*//*                .antMatchers("/main").hasRole("Admin")
                .antMatchers("/main").hasRole("Dozent")*//*
                //.anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                .defaultSuccessUrl("/main")
                    .permitAll()
                    .and()
                .logout().permitAll();
                }*/
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                //.antMatchers("/css/**", "/js/**", "/images/**", "/Kalender/**").permitAll()
                //.anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                //.defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    
    }
    
    

/*    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails stevenUser = User.builder()
                .username("steven")
                .password(passwordEncoder.encode("password"))
                .roles("Student") // ROLE_STUDENT
                .build()
        ;
    
        UserDetails dozentUser = User.builder()
                .username("testdozent")
                .password(passwordEncoder.encode("test"))
                .roles("Dozent") // ROLE_Dozent
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
                adminUser,
                dozentUser
        );
    }*/
/*    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }*/
    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //super.configure(http);
//
//        http
//                .authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//        ;
//    }

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
}

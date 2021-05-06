package dhbw.vs.uniplaner.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

/*    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }*/
/*        @Bean
    public String passwordEncoder(String password) {
            String hashedPassword;
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            hashedPassword = passwordEncoder(password);
        return hashedPassword;
    }*/
}

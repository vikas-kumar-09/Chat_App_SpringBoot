// package in.vikas.chatapp.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/", "/hello", "/websocket", "/css/**", "/images/**", "/js/**").permitAll() // Permit access to these URLs without authentication
//                 .anyRequest().authenticated() // Require authentication for any other URL
//                 .and()
//             .formLogin() // Use form-based authentication
//                 .loginPage("/login") // Specify the URL of the login page
//                 .permitAll() // Allow anyone to access the login page
//                 .and()
//             .logout() // Configure logout
//                 .logoutSuccessUrl("/") // Redirect to home page after logout
//                 .permitAll(); // Allow anyone to logout
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         // Use NoOpPasswordEncoder for simplicity (not recommended for production)
//         return NoOpPasswordEncoder.getInstance();
//     }
// }
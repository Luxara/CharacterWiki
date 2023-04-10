package fi.hh.Wikidemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
            new AntPathRequestMatcher("/api/**"),
            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/characters/**"),
            new AntPathRequestMatcher("/character/**"),
            new AntPathRequestMatcher("/locations/**"),
            new AntPathRequestMatcher("/location/**")
    };
	
		
		@Bean
		public SecurityFilterChain configure(HttpSecurity http) throws Exception{
			http
			//.csrf().disable() //for Postmans POST, PUT & DEL testing to work
			.authorizeRequests().antMatchers("/css/**").permitAll()
			.requestMatchers(WHITE_LIST_URLS).permitAll()
				.anyRequest().authenticated()
				.and().formLogin().defaultSuccessUrl("/characterlist", true).permitAll()
				.and().logout().permitAll()
				.and().httpBasic();
			
			return http.build();	
		}
		
//		@Bean
//		public UserDetailsService userDetailsService() {
//			List<UserDetails> users = new ArrayList<UserDetails>();
//			
//			PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//			
//			UserDetails user1 = User
//					.withUsername("user")
//					.password(passwordEncoder.encode("user"))
//					.roles("USER")
//					.build();
//			
//			users.add(user1);
//			
//			UserDetails user2 = User
//					.withUsername("admin")
//					.password(passwordEncoder.encode("admin"))
//					.roles("USER, ADMIN")
//					.build();
//			
//			users.add(user2);
//			
//			return new InMemoryUserDetailsManager(users);
//		}
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		}
	}



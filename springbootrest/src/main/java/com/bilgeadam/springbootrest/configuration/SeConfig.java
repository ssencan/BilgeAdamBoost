package com.bilgeadam.springbootrest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//metodların üstünde @secured veya @preauthorize yazabilmek için
//@EnableMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity // deprecate oldu
public class SeConfig // extends WebSecurityCongigurerAdapter bu da deprecated
{
//	@Bean(name = "authManager")
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
//	{
//		return authenticationConfiguration.getAuthenticationManager();
//	}

	@Bean
//	@DependsOn(value = "authManager")
	public SecurityFilterChain configure(HttpSecurity http, @Autowired AuthenticationConfiguration authenticationConfiguration) throws Exception
	{
		// sadece post işlemleri authenticated yapılabilir
//		http.authorizeRequests().antMatchers(HttpMethod.POST).authenticated();
		// geri kalan bütün endpoint 'ler permit durumunda, bunu üsttekinden önce yapamazsınız. alttaki ile bu builder gibi yan yana yazılabilir.
//		http.authorizeRequests().anyRequest().permitAll();
		// ------------------------------------------
		// save işlemini sadece admin rolündekiler yapsın gibi zaten authenticate
		// olmadan rol olmaz
		// önce anyrequest yazarsam Can't configure antMatchers after anyRequest hatası
		// olur
//		http.authorizeRequests().anyRequest().permitAll();
		// burası grantedauthority 'lere bakıyor
		// veritabanında role_user yazar burada user ile kontrol edersiniz
		// role isimleri standart değil abuziddin falan olabilir
		// belki de burada belirtmek yerine controller 'da @Secured veya @preauthorize
		// kullanınılabilir
//		http.authorizeHttpRequests().requestMatchers(HttpMethod.DELETE).hasRole("SUPER");
//		http.authorizeHttpRequests().requestMatchers("/ogretmen/deleteById/*").hasRole("SUPER");
		// ** baştan yazarsan o path içindeki herşeyi ezersin
//		http.authorizeHttpRequests().requestMatchers("/ogretmen/**").hasRole("NORMAL");
//		http.authorizeHttpRequests().anyRequest().permitAll();
		// -----------------------------------------
		// mvc için geçerli
//		http.authorizeRequests().antMatchers("/error").permitAll();
//		// hepsini birden istisnasız kapatmak için tek satır
//		http.authorizeRequests().anyRequest().authenticated();
		// -----------------------------------------
//		http.authorizeHttpRequests(customizer -> customizer.requestMatchers(HttpMethod.GET).authenticated().anyRequest().permitAll());
//		http.authorizeHttpRequests(customizer -> customizer.requestMatchers("/ogretmen/getall").hasRole("USER"));
		//bir endpoint controller pathine hasrole verip aynı metod için diğer controller pathlerinde authorize yoksa ve login yapmasın istiyosan altta extra permit all yazıcan.
		// genel endpoint hasrole yapınca zaten authonticationa yazmasan da token kontrolü için authentication gerekiyor.
		// permitall yazmadan hasrole tüm endpointleri kapıyor
//		http.authorizeHttpRequests(customizer -> customizer.requestMatchers("/**").permitAll());
		
//		http.authorizeHttpRequests(customizer -> customizer.requestMatchers(HttpMethod.DELETE).authenticated().anyRequest().permitAll());
//		http.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated());
		// ------------------- buradan aşağı dokunma -------------
		// post yapabilmek için
		http.csrf(customizer -> customizer.disable());
        // stateless, postman 'da request 'leri cache 'lememesi için, çünkü buras?
        // restull
//		http.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		http.formLogin(); // bunu yazmadan direkt login sayfası gelmiyor burada eziyor bi şekilde logini o yüzden yazmak gerek.
		//Endpointleri açar post hariç 403 forbidden fırlatır. onun için csrf customizer disabled yapılmalı ama hoş değil. Statless jwt tokenını hafıazaya atmaması, session yapmaması için
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		// sırası muhtemelen önemlidir
		http.addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()));
		http.addFilterAfter(new JWTAuthorizationFilter(), JWTAuthenticationFilter.class);
		// http.csrf().disable().addFilter(new
		// JWTAuthorizationFilter(authenticationManager())).addFilter(new
		// JWTAuthenticationFilter(authenticationManager())).authorizeRequests().antMatchers(HttpMethod.POST).authenticated().and().authorizeRequests().anyRequest().permitAll();
		return http.build();
	}
}
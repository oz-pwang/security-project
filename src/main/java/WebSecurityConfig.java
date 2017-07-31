import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by ozintel06 on 16/8/31.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserLoginService userLoginService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
        .and()
//      authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护
//        定义不用限制的路径
//        .antMatchers("请求路径").permitAll()
//        定义需要控制访问的路径
//        .antMatchers("请求路径").hasRole("角色")
        .authorizeRequests()
//        .antMatchers("/mall","/merchant/create","/consumer/create").permitAll()
//        .antMatchers("/merchant/**").hasRole("merchant")
//        .antMatchers("/consumer/**").hasRole("consumer")
        .antMatchers().permitAll()
        .anyRequest().authenticated()
//      formLogin()定义当需要用户登录时候，转到的登录页面
        .and()
        .formLogin()
        .usernameParameter("name")
        .passwordParameter("password")
        .loginPage("/login")
        .failureUrl("/login?failed=true")
        .permitAll()
        .and()
        .logout()
        .permitAll();

  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//     在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
//    .inMemoryAuthentication().withUser("user").password("password").roles("USER");
    auth.userDetailsService(userLoginService);


  }

}

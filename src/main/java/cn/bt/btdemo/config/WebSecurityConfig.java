package cn.bt.btdemo.config;

import cn.bt.btdemo.filter.jwt.JwtAuthorizationTokenFilter;
import cn.bt.btdemo.service.jwt.JwtAuthenticationEntryPoint;
import cn.bt.btdemo.service.jwt.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    // Custom JWT based security filter
    @Autowired
    JwtAuthorizationTokenFilter authenticationTokenFilter;
    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 采用自定义用户认证
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(jwtUserDetailsService)
                .passwordEncoder(passwordEncoderBean());
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(jwtUserDetailsService)
            .passwordEncoder(passwordEncoderBean());
    }*/

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 限制请求
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //禁用springsecurity自带的csrf攻击处理
            .csrf().disable()
            //异常处理拦截
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .and()
            //定制我们子的session策略 --> 调整让SpringSecurity不创建和使用session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            //开始限制请求
            .authorizeRequests()
                .antMatchers("/login/**").permitAll()
                //任何请求都必须经过身份验证
                .anyRequest().authenticated();
        http
            // UsernamePasswordAuthenticationFilter 前添加 BeforeLoginFilter
            .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // disable page caching
        http
            .headers() // 设置安全响应头
            .frameOptions().sameOrigin()  //阻止点击劫持意思是页面只能被本站页面嵌入到iframe或者frame中。这样就解决了X-Frame-Options头未设置的漏洞。
            .cacheControl(); //禁用对机密信息的缓存
    }


}

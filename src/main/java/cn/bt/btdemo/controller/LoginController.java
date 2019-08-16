package cn.bt.btdemo.controller;

import cn.bt.btdemo.entity.ResponseJson;
import cn.bt.btdemo.entity.admin.Admin;
import cn.bt.btdemo.entity.admin.SysPerm;
import cn.bt.btdemo.exception.AuthenticationException;
import cn.bt.btdemo.model.jwt.JwtAuthenticationRequest;
import cn.bt.btdemo.service.AdminService;
import cn.bt.btdemo.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {
    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AdminService adminService;
    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @GetMapping("/test")
    public String test01(){
        return "最美的不是下雨天，是曾与你躲过雨的屋檐~";
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest){

        try{
            //校验密码
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);//生成token
            Admin admin = new Admin();
            admin.setUsername(userDetails.getUsername());
            Admin a =adminService.findOneAdminByCondition(admin);

            //查询该用户拥有的所有角色
            List<SysPerm> permList=adminService.findSysFuncPermsByAdminId(a.getId()+"");
            a.setPassword("****");
            return ResponseEntity.ok(new ResponseJson(token,permList,a));
        }catch (Exception e){
            log.error("", e);
            return ResponseEntity.ok(new ResponseJson(false,"账号不存在或已被禁用"));
        }
    }

    /**
     * 完成用户名和密码的校验
     * @param username
     * @param password
     */
    private void authenticate(String username, String password) {
        //校验空
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            //校验密码
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!(没有用的用户)", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials!(坏证书)", e);
        }
    }

}

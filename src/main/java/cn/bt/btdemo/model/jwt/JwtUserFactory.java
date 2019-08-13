package cn.bt.btdemo.model.jwt;

import cn.bt.btdemo.entity.admin.Admin;
import cn.bt.btdemo.entity.admin.SysRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Admin admin) {
        return new JwtUser(
                admin.getId(),
                admin.getUsername(),
                admin.getPassword()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<SysRole> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getTitle()))
                .collect(Collectors.toList());
    }
}

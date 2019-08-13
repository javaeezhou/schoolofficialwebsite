package cn.bt.btdemo.service.jwt;

import cn.bt.btdemo.dao.IAdminDao;
import cn.bt.btdemo.entity.admin.Admin;
import cn.bt.btdemo.model.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IAdminDao adminDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin a = new Admin();
        a.setUsername(username);
        a.setStatus(1);
        Admin admin = adminDao.findOneAdminByCondition(a);
        if (admin == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(admin);
        }
    }
}

package cn.bt.btdemo.test;

import cn.bt.btdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test02 {
    @Autowired
    public void test(AdminService adminService){
        System.out.println("我真的很帅啊");
    }
}

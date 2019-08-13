package cn.bt.btdemo.dao;

import cn.bt.btdemo.entity.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IAdminDao {
/*-------------------------------------------------generated code start,do not update-----------------------------------------------------------*/
    List<Admin> findAdminListByCondition(Admin admin);

    long findAdminCountByCondition(Admin admin);

    Admin findOneAdminByCondition(Admin admin);

    Admin findAdminById(@Param("id") String id);

    void saveAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(@Param("id") String id);

    void deleteAdminByCondition(Admin admin);

    void batchSaveAdmin(List<Admin> admins);
/*-------------------------------------------------generated code end,do not update-----------------------------------------------------------*/
}

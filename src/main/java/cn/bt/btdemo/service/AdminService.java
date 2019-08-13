package cn.bt.btdemo.service;

import cn.bt.btdemo.dao.IAdminDao;
import cn.bt.btdemo.entity.admin.Admin;
import cn.bt.btdemo.util.SequenceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private IAdminDao adminDao;
    @Autowired
    private SequenceId sequenceId;
/*-------------------------------------------------generated code start,do not update-----------------------------------------------------------*/
    @Transactional(readOnly = true)
    public Admin findAdminById(String id) {
        return adminDao.findAdminById(id);
    }
    @Transactional
    public void saveAdmin(Admin admin) {
        admin.setId(sequenceId.nextId());
        adminDao.saveAdmin(admin);
    }
    @Transactional(readOnly = true)
    public List<Admin> findAdminListByCondition(Admin admin) {
        return adminDao.findAdminListByCondition(admin);
    }
    @Transactional(readOnly = true)
    public Admin findOneAdminByCondition(Admin admin) {
        return adminDao.findOneAdminByCondition(admin);
    }
    @Transactional(readOnly = true)
    public long findAdminCountByCondition(Admin admin) {
        return adminDao.findAdminCountByCondition(admin);
    }
    @Transactional
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }
    @Transactional
    public void deleteAdmin(String id) {
        adminDao.deleteAdmin(id);
    }
    @Transactional
    public void deleteAdminByCondition(Admin admin) {
        adminDao.deleteAdminByCondition(admin);
    }
    @Transactional
    public void batchSaveAdmin(List<Admin> admins){
        admins.forEach(admin -> admin.setId(sequenceId.nextId()));
        adminDao.batchSaveAdmin(admins);
    }
/*-------------------------------------------------generated code end,do not update-----------------------------------------------------------*/
}

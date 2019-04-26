package service;

import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Admin;
import pojo.AdminExample;
import service.all_interface.AdminInterface;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/11 0011 18:24
 * @Version 1.0
 */
@Service
public class Adminimpl implements AdminInterface {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Admin> getAdmin(AdminExample adminExample) throws Exception {

        return adminMapper.selectByExample(adminExample);
    }

    @Override
    public void Insert(Admin admin) throws Exception {
        adminMapper.insert(admin);
    }
}

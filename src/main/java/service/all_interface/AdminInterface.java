package service.all_interface;

import pojo.Admin;
import pojo.AdminExample;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/11 0011 18:21
 * @Version 1.0
 */
public interface AdminInterface {
    List<Admin>  getAdmin(AdminExample adminExample)throws Exception;
    void Insert(Admin admin)throws  Exception;
}

package service.all_interface;

import pojo.User;
import pojo.UserExample;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/20 0020 00:29
 * @Version 1.0
 */
public interface UserInterface {
    User getUserByID()throws Exception;
    Boolean judgeUser(User user)throws Exception;
    List<User> findUser(UserExample userExample)throws Exception;
}

package service;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import pojo.UserExample;
import service.all_interface.UserInterface;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/20 0020 00:31
 * @Version 1.0
 */
@Service
public class UserImpl implements UserInterface {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findUser(UserExample userExample) throws Exception {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User getUserByID() throws Exception {
        return null;
    }

    @Override
    public Boolean judgeUser(User user){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserEqualTo(user.getUser());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> list=userMapper.selectByExample(userExample);
        if(list.size()!=0)
            return true;
        return false;
    }
}

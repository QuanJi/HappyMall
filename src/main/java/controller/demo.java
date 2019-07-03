package controller;

import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;
import service.OrderImpl;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/8 0008 21:55
 * @Version 1.0
 */
@Controller
public class demo {
    @Autowired
    AdminMapper adminMapper;
    @RequestMapping("/test")
    @ResponseBody
    public String demo()throws Exception{

        Admin order= adminMapper.getById(3,"1234");
        return order.getAdmin();
    }

}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    OrderImpl orderimpl;
    @RequestMapping("/demo")
    public void demo(TestPOJO testPOJO)throws Exception{

        List<Order> order= orderimpl.findUserAndOrderDetail();
        return;
    }

}

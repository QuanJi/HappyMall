package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;
import service.GoodsInterfaceServiceImpl;
import service.OrderImpl;
import service.UserImpl;
import service.all_interface.OrderInterface;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/16 0016 22:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/cart")
public class CartOrderManage {
    @Autowired
    GoodsInterfaceServiceImpl goodsInterfaceService;
    @Autowired
    UserImpl userImpl;
    @Autowired
    OrderImpl orderImpl;
    @RequestMapping("/cart")
    public  void Cart(HttpServletRequest request, HttpServletResponse response,long id) throws Exception{
        Goods goods=goodsInterfaceService.getGoodsByID(id);

        Cookie cookie1=getCookie("idList",request);
        if(cookie1==null){
            Cookie cookie2=new Cookie("idList",String.valueOf(goods.getId())+"#");
            cookie2.setPath("/");
            cookie2.setMaxAge(60*60*24*10);
            response.addCookie(cookie2);
        }else{
            if(cookie1.getValue().indexOf(String.valueOf(id))==-1){
                cookie1.setValue(cookie1.getValue()+goods.getId()+"#");
                cookie1.setPath("/");
                response.addCookie(cookie1);
            }
        }
        Cookie cookie=new Cookie(String.valueOf(id),goods.toString());
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*10);
        response.addCookie(cookie);
    }
    @RequestMapping("/checkout")
    public String Checkout(HttpServletRequest request){

        Cookie cookie=getCookie("idList",request);
        String[] strings=cookie.getValue().split("#");
        List<Goods> list=new ArrayList<>();
        for(String string:strings) {
            Cookie cookie1=getCookie(string,request);
            if(cookie1!=null){
                Goods goods=new Goods();
                String[] info=cookie1.getValue().split("#");
                for(String string1:info){
                    if (string1.split("=")[0].equals("id"))
                        goods.setId((long)Integer.parseInt(string1.split("=")[1]));
                    if (string1.split("=")[0].equals("goodsName"))
                        goods.setGoodsName(string1.split("=")[1]);
                    if (string1.split("=")[0].equals("goodsImage"))
                        goods.setGoodsImage(string1.split("=")[1]);
                    if (string1.split("=")[0].equals("goodsPrice"))
                        goods.setGoodsPrice(Double.valueOf(string1.split("=")[1]));

                }
                list.add(goods);
            }
        }
        if(list.size()>0){
            request.setAttribute("checkout",list);
        }
        return "/html/checkout.jsp";
    }
    @RequestMapping(value = "/order")
    @ResponseBody
    public String GetOrder(HttpSession session,String info) throws Exception{
        String username=(String)session.getAttribute("user");
        if(username==null)
            return "请登录!";
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserEqualTo(username);
        List<User> userList=userImpl.findUser(userExample);

        String[] strings=info.split(";");
        Order order=new Order();
        order.setUser(userList.get(0));
        List<OrderDetail> detailList=new ArrayList<>();
        for(String userinfo:strings){
                OrderDetail detail=new OrderDetail();
                detail.setGoodsId(Integer.valueOf(userinfo.split(",")[0]));
                detail.setNumber(Long.valueOf(userinfo.split(",")[1]));
                detailList.add(detail);
        }
        if(detailList.size()!=0){
            order.setList(detailList);
        }
        order.setUserId(order.getUser().getId());
        order.setCreateTime(new java.sql.Date(System.currentTimeMillis()));
        orderImpl.InsertOrder(order);
        return info;
    }


    public Cookie getCookie(String key,HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(key)){
                return cookie;
            }
        }
        return null;
    }

}

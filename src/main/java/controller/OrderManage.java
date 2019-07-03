package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Goods;
import pojo.Order;
import pojo.OrderDetail;
import service.GoodsInterfaceServiceImpl;
import service.OrderDetailImpl;
import service.OrderImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/24 0024 10:41
 * @Version 1.0
 */
@Controller
public class OrderManage {
    @Autowired
    OrderImpl orderImpl;
    @Autowired
    OrderDetailImpl orderDetail;
    @Autowired
    GoodsInterfaceServiceImpl goodsInterfaceService;
    @RequestMapping("/orderManage")
    public String OrderManage(){
        return "/WEB-INF/manage/member-list.html";
    }
    @RequestMapping("/findOrder")
    @ResponseBody
    public List<Order> FindOrder()throws Exception{
        List<Order> orders=orderImpl.findUserAndOrderDetail();

        return orders;
    }
    @RequestMapping("/member-show")
    public String MemberShow(Integer orderId, HttpServletRequest request) throws Exception{
        List<OrderDetail> orders=orderDetail.FindOrderDetail(orderId);
        List<Goods> goods=new ArrayList<>();
        for(OrderDetail detail:orders){
            Goods goods1=goodsInterfaceService.getGoodsByID(detail.getGoodsId());
            goods.add(goods1);
        }


        request.setAttribute("detail",orders);
        request.setAttribute("goods",goods);
        return "/WEB-INF/manage/member-show.jsp";
    }
}

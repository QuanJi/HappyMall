package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Goods;
import pojo.GoodsExample;
import pojo.MyPageHelder;
import service.GoodsInterfaceServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/14 0014 15:12
 * @Version 1.0
 */
@Controller
@RequestMapping("/HappyMall")
public class GoodsDisplayManage {
    @Autowired
    GoodsInterfaceServiceImpl goodsInterfaceService;
    @RequestMapping("/index")
    public String GotoIndex(Model model, HttpSession session, HttpServletRequest request)throws Exception{
        GoodsExample goodsExample=new GoodsExample();
        MyPageHelder helder =goodsInterfaceService.getGoodsList(goodsExample,1,9);
        model.addAttribute("goodsList",helder.getGoodsList());
        String user=(String) session.getAttribute("user");
        if(user!=null)
            request.setAttribute("user",user);
        return "/jsp/index.jsp";
    }

}

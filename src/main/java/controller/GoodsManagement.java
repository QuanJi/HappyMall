package controller;

import mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.*;
import service.ColumnImpl;
import service.GoodsInterfaceServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/5 0005 15:33
 * @Version 1.0
 */
@Controller
public class GoodsManagement {
    @Autowired
    ColumnImpl columnImpl;
    @Autowired
    ColumnmanageExample columnmanageExample;
    @Autowired
    GoodsInterfaceServiceImpl goodsInterfaceService;

    @RequestMapping(value = "/article-list")
    public ModelAndView LoadingGoods(Integer page,String condition,String content) throws Exception{
        GoodsExample goodsExample=new GoodsExample();
        GoodsExample.Criteria criteria=goodsExample.createCriteria();
        criteria.andGoodsClassifyLike("%"+condition+"%");
        criteria.andGoodsNameLike("%"+content+"%");
        ModelAndView modelAndView=new ModelAndView();
        System.out.println(condition+"sss"+content);
        MyPageHelder goodsList=goodsInterfaceService.getGoodsList(goodsExample,page,10);
        List<Columnmanage> list=columnImpl.getColumn(columnmanageExample);
        modelAndView.addObject("goodsList",goodsList);
        modelAndView.addObject("page",page);
        modelAndView.addObject("column",list);
        modelAndView.setViewName("/WEB-INF/manage/article-list.jsp");
            return modelAndView;
    }

    @RequestMapping(value = "/article-add")
    public String LoadingGoods1(Model model) throws Exception{
            List<Columnmanage> list=columnImpl.getColumn(columnmanageExample);
            model.addAttribute("column",list);
            return "/WEB-INF/manage/article-add.jsp";
    }
    @RequestMapping("/article-add1")
    public String articleAdd(Goods goods, MultipartFile image,Model model) throws Exception{
        if(image!=null&&image.getOriginalFilename().length()!=0){

            goods.setGoodsImage(getImagePath(image));
            goodsInterfaceService.InsertGoods(goods);
            model.addAttribute("judge","ok");
            return "article-list.action?page=1&condition&content";
        }
        return "/WEB-INF/manage/error.html";
    }
    @RequestMapping("/deleteAllID")
    public void deleteGoods(HttpServletRequest request,HttpServletResponse response,long[] deleteID) throws Exception{
        if(deleteID.length>0){
                goodsInterfaceService.DeleteGoods(deleteID);
                request.getRequestDispatcher("article-list.action?page=1&condition&content").forward(request,response);

        }

    }

    @RequestMapping("/updateGoods")
    public void updateGoods(HttpServletResponse response,HttpServletRequest request,long index)throws Exception{
        List<Columnmanage> list=columnImpl.getColumn(columnmanageExample);
        request.setAttribute("column",list);
        Goods goods=goodsInterfaceService.getGoodsByID(index);
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("/WEB-INF/manage/article-update.jsp").forward(request,response);
    }
    @RequestMapping("/article-update")
    public  String articleUpdate(Goods goods,Model model,MultipartFile image)throws Exception{
        goods.setGoodsImage(getImagePath(image));
        goodsInterfaceService.UpdateGoods(goods);
        model.addAttribute("update","ok");
        return "article-list.action?page=1&condition&content";
    }

    public String getImagePath(MultipartFile image)throws Exception{
        String path="C:\\Users\\Administrator\\IdeaProjects\\HappyMall\\src\\main\\webapp\\WEB-INF\\manage\\image\\";
        String imagename=image.getOriginalFilename();
        File file=new File(path+imagename);
        image.transferTo(file);
        return "/image/"+imagename;
    }


}

package controller;

import com.alibaba.druid.Constants;
import com.alibaba.druid.util.FnvHash;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pojo.Admin;
import pojo.AdminExample;
import pojo.User;
import service.Adminimpl;
import service.UserImpl;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/9 0009 20:39
 * @Version 1.0
 */
@Controller
public class LoginManage {
    private static Random r = new Random();
    private static char[] chs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int NUMBER_OF_CHS = 4;
    private static final int IMG_WIDTH = 65;
    private static final int IMG_HEIGHT = 25;
    @Autowired
    Adminimpl adminimpl;
    @Autowired
    UserImpl userImpl;

    @RequestMapping("/welcome")
    public String Welcome() {
        return "/WEB-INF/manage/welcome.html";
    }

    @RequestMapping("/admin")
    public String login(HttpSession session, Integer remember,
                        String username, String password,
                        String validator, HttpServletResponse response,
                        HttpServletRequest request) throws Exception {
        /* String str=session1.getAttribute("validatorCode").toString();*/
      /*  RequestAttributes asd=RequestContextHolder.getRequestAttributes();
        HttpServletRequest request1 = ((ServletRequestAttributes)asd).getRequest();*/
        if (validator.compareTo((String) session.getAttribute("validatorCode")) != 0) {
            request.setAttribute("validatorError", "验证码错误!");
            return "/login/admin_login.jsp";
        }
        if (judgeAdmin(username, password, request)) {
            session.setAttribute("admin", username);
            if (remember == 1) {
                Cookie cookie = new Cookie("admin", username);
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24 * 7);
                Cookie cookie1 = new Cookie("password", password);
                cookie1.setPath("/");
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie);
                response.addCookie(cookie1);
            } else {
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getValue().equals(username) || cookie.getValue().equals(password)) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }

            }
            return "/WEB-INF/manage/index.jsp";
        } else {

            return "/login/admin_login.jsp";
        }


    }

    @RequestMapping(value = "/validatorCode")
    public void ValidatorCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Color c = new Color(200, 200, 255);
        g.setColor(c);
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
        StringBuffer sb = new StringBuffer();
        int index;
        for (int i = 0; i < NUMBER_OF_CHS; i++) {
            index = r.nextInt(chs.length);
            g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));
            g.drawString(chs[index] + "", 15 * i + 3, 18);
            sb.append(chs[index]);
        }
        request.getSession().setAttribute("validatorCode", sb.toString());
        /* request.getSession().setAttribute("validatorCode", sb.toString());*/
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    @RequestMapping("/register")
    public String Register() {
        return "/WEB-INF/manage/admin-add.html";
    }

    @RequestMapping("/gotoLogin")
    public String Login() {
        return "/login/admin_login.jsp";
    }

    @RequestMapping("/registerSubmit")
    public String RegisterSubmit(Admin admin) throws Exception {

        adminimpl.Insert(admin);
        return "/login/admin_login.jsp";
    }

    @RequestMapping("/login")
    public String GotoLogin(HttpSession session) {
        return "/login/admin_login.jsp";
    }


    @RequestMapping("/Userlogin")
    @ResponseBody
    public String UserLogin(String username, String password, HttpServletRequest request) {
        User user = new User();
        user.setPassword(password);
        user.setUser(username);
        if (userImpl.judgeUser(user)) {
            request.getSession().setAttribute("user", username);
            return "登陆成功!";
        }

        return "登陆失败！";
    }

    public boolean judgeAdmin(String username, String password, HttpServletRequest request) throws Exception {

        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminEqualTo(username);
        List<Admin> list = adminimpl.getAdmin(adminExample);
        if (list.size() != 0)
            criteria.andPasswordEqualTo(password);
        else {
            request.setAttribute("errorAdmin", "账号不存在！");
            return false;
        }

        List<Admin> adminList = adminimpl.getAdmin(adminExample);
        if (adminList.size() != 0)
            return true;
        else {
            request.setAttribute("errorPassword", "密码错误！");
            return false;
        }

    }
}

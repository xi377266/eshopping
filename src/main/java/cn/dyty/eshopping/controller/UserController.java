package cn.dyty.eshopping.controller;

import cn.dyty.eshopping.bean.User;
import cn.dyty.eshopping.service.IUserService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String callback = request.getParameter("callback");
        response.setContentType("application/json;charset=UTF-8");
        Gson gson=new Gson();
        String username=request.getParameter("Username");
        String password=request.getParameter("Password");
        User user=userService.findByNP(username,password);
        String s=gson.toJson(user);
        s= callback+ "("+s+")";
        System.out.println("111111111111111111111-----"+username+"----------"+password);
        response.getWriter().write(s);
        return null;
    }

}

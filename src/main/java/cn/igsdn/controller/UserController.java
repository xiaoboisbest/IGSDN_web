package cn.igsdn.controller;

import cn.igsdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/genUser/login")
    public String login() {
        return "genUser/login";
    }

    @ResponseBody
    @RequestMapping(value = "/genUser/checkLogin", method = RequestMethod.POST)
    public Object genLogin(@RequestBody Map<String, String> map, HttpSession session) {
        System.out.println("-------------------------");
        System.out.println("用户登录：");
        System.out.println("用户名：" + map.get("loginName") + "\\密码：" + map.get("password"));
        Object o = userService.login(1, map.get("loginName"), map.get("password"));
        if (o != null)
            session.setAttribute("genUser", o);
        return o;
    }

    @RequestMapping(value = "/genUser/index")
    public String userIndex() {
        return "genUser/index";
    }

}

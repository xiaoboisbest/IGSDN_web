package cn.igsdn.controller;

import cn.igsdn.domain.User;
import cn.igsdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/genUser/login")
    public String login(User user) {

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

    /**
     * 检查输入的用户名是对数据库进行检查，查看是否注册过
     * @param loginName
     * @return
     */
    @RequestMapping("/genUser/checkRegister")
    public String checkRegister(@RequestParam(value="loginName")String loginName) {
        String msg = null;
        return msg;
    }

    /**
     * 注册：
     *   将前台信息注册到数据库中
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/genUser/register")
    public Integer register(@RequestBody Map<String, String> map) {
        Integer msg = null;// 1-注册成功 0-注册失败 2-注册过
        if (userService.checkRegister(map.get("Loginname"))) {
            msg = 2;
        } else if (userService.register(map)) {
            //进行注册
            msg = 1;
        } else if (!userService.register(map)) {
            //注册失败
            msg = 0;
        }
        return msg;
    }

}

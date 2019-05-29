package cn.igsdn.controller;

import cn.igsdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/genUser/checkLogin", method = RequestMethod.POST)
    public Object genLogin(@RequestBody Map<String, String> map, HttpSession session) {
//        System.out.println("用户登录：");
//        System.out.println("用户名：" + map.get("loginName") + "\\密码：" + map.get("password"));
        Object o = userService.login(1, map.get("loginName"), map.get("password"));
        if (o != null)
            session.setAttribute("genUser", o);
        return o;
    }


    /**
     * 检查输入的用户名是对数据库进行检查，查看是否注册过
     *
     * @param loginName
     * @return
     */
    @RequestMapping("/genUser/checkRegister")
    public String checkRegister(@RequestParam(value = "loginName") String loginName) {
        String msg = null;
        return msg;
    }

    /**
     * 注册：
     * 将前台信息注册到数据库中
     *
     * @param map
     * @return Integer(null : 服务器错误 ， 0 : 注册失败, 1 : 注册成功)
     */
    @RequestMapping(value = "/genUser/register")
    public Integer register(@RequestBody Map<String, String> map) {
        String loginName = map.get("LoginName"); // 登录名
        String password = map.get("Password1"); // 密码
        String uname = map.get("Uname"); // 用户名
        Boolean b = userService.register(loginName, password, uname);
        if (b == null) {
            return null;
        } else if (b == true) {
            return 1;
        } else {
            return 0;
        }
    }

}

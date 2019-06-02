package cn.igsdn.controller;

import cn.igsdn.domain.DocumentComment2;
import cn.igsdn.dto.GenUserInfo;
import cn.igsdn.dto.GenUserInformation;
import cn.igsdn.dto.UserMemoryInfoDTO;
import cn.igsdn.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:8081")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/genUser/getUserMemoryInfo/{userId}", method = RequestMethod.GET)
    public UserMemoryInfoDTO getUserMemoryInfoByUserId(@PathVariable Integer userId) {
        return userService.selectUserMemoryInfoByUserId(userId);
    }

    @RequestMapping(value = "/genUser/updateLoginName", method = RequestMethod.PUT)
    public Boolean updateLoginName(@RequestBody Map<String, String> map) {
        Integer userId = Integer.parseInt(map.get("userId"));
        String tel = map.get("tel");
        String email = map.get("email");
        return userService.updateLoginNameByPrimaryKey(userId, tel, email);
    }

    @RequestMapping(value = "/genUser/countUnReadUserInformationByUserId/{userId}", method = RequestMethod.GET)
    public Long countUnReadUserInformationByUserId(@PathVariable("userId") Integer userId) {
        return userService.countUnReadUserInformationByUserId(userId);
    }

    //添加评论
    @RequestMapping(value = "/genUser/userInformationRemark", method = RequestMethod.POST)
    public Boolean InformationRemark(@RequestBody Map<String, Object> map) {
        String documentComment2String = (String) map.get("documentComment2String");
        String receive = map.get("receive").toString();
        DocumentComment2 documentComment2 = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
            documentComment2 = objectMapper.readValue(documentComment2String, DocumentComment2.class);
            System.out.println(documentComment2.toString());
            Boolean flag = userService.insertInformationRemark1(documentComment2);
            if (flag) {
                System.out.println(documentComment2.getId());
                Boolean flag1 = userService.insertInformationRemark2(documentComment2.getId(), receive);
                if (flag1) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除用户通知信息
    @RequestMapping(value = "/genUser/userInformationDelete/{id}", method = RequestMethod.DELETE)
    public Boolean deleteUserInformation(@PathVariable("id") Integer id) {
        //System.out.println(id);
        return userService.deleteUserInformation(id);
    }

    //显示对话
    @RequestMapping(value = "/genUser/showRemark/{id}", method = RequestMethod.GET)
    public Map<String, List> showRemark(@PathVariable("id") Integer id) {
        return userService.selectAllRemark(id);
    }

    //显示用户评论
    @RequestMapping(value = "/genUser/userInformation/{loginName}", method = RequestMethod.GET)
    public List<GenUserInformation> selectUserInformation(@PathVariable("loginName") String loginName) {
        return userService.selectUserInformation(loginName);
    }

    // 更新userInformationID 的 state 是否已读
    @RequestMapping(value = "/genUser/userInformationRemove", method = RequestMethod.PUT)
    public Boolean updateInformationState(@RequestBody Map<String, String> map) {
        String userInformationID = map.get("userInformationID");
        String state = map.get("state");
        System.out.println(userInformationID + "=======" + state);
        return userService.updateInformationState(userInformationID, state);
    }

    @RequestMapping(value = "/genUser/updateUserInfo/{userId}", method = RequestMethod.PUT)
    public Boolean updateUserInfo(@RequestBody Map<String, String> map, @PathVariable("userId") Integer userId) {
        String gender = map.get("gender");
        String age = map.get("age");
        String name = map.get("name");
        String uname = map.get("uname");
        return userService.updateUserInfo(userId, gender, age, name, uname);
    }

    @RequestMapping(value = "/genUser/selectUserInfo/{userId}", method = RequestMethod.GET)
    public GenUserInfo selectUserInfo(@PathVariable("userId") Integer userId) {
        return userService.selectUserInfo(userId);
    }


    // 修改密码
    @RequestMapping(value = "/genUser/updatePassword/{userId}", method = RequestMethod.PUT)
    public Boolean updatePassword(@PathVariable("userId") Integer userId, @RequestBody Map<String, String> map) {
        String passWord1 = map.get("oldPass");
        String passWord2 = map.get("pass");
        return userService.updatePassword(userId, passWord1, passWord2);
    }

    @RequestMapping(value = "/genUser/checkPassword", method = RequestMethod.POST)
    public Boolean checkPassword(@RequestBody Map<String, String> map) {
        int userId = Integer.parseInt(map.get("userId"));
        String password = map.get("password");
        return userService.checkPasswordByPrimaryKey(userId, password);
    }

    @RequestMapping(value = "/genUser/checkLogin", method = RequestMethod.POST)
    public Object genLogin(@RequestBody Map<String, String> map, HttpSession session) {
        Object o = userService.login(1, map.get("loginName"), map.get("password"));
        if (o != null)
            session.setAttribute("genUser", o);
        return o;
    }

    @RequestMapping("/genUser/checkRegister")
    public String checkRegister(@RequestParam(value = "loginName") String loginName) {
        String msg = null;
        return msg;
    }

    @RequestMapping(value = "/genUser/register")
    public Integer register(@RequestBody Map<String, String> map) {
        String loginName = map.get("LoginName"); // 登录名
        String password = map.get("Password1"); // 密码
        String uname = map.get("Uname"); // 用户名
        System.out.println(uname);
        System.out.println(password + "密码-----------");
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

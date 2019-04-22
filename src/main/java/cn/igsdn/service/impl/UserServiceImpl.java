package cn.igsdn.service.impl;

import cn.igsdn.dao.UserMapper;
import cn.igsdn.domain.User;
import cn.igsdn.service.UserService;
import cn.igsdn.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public Object login(int type, String loginName, String password) {
        try {
            switch (type) { // 登陆方式（0：管理员；1：普通用户）
                case 0:
                    return null;
                case 1: {
                    return userMapper.selectGenUserDTOByPrimaryKey(loginName, password);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }


    public Boolean checkRegister(String loginName) {
        try {
            if (StringUtils.isloginName(loginName)) {
                int result = userMapper.selectByLoginName(loginName);
//                System.out.println("验证结果：" + result);
                if (result != 0) {
                    return false; // 用户名重复，不可注册
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public Boolean register(String loginName, String password, String uname) {
        if (!StringUtils.isNotBlank(loginName) || !StringUtils.isNotBlank(uname) || !StringUtils.isNotBlank(password)) {
//          System.out.println("输入为空");
            return false;
        }
        if (uname.trim().length() > 10 || password.trim().length() > 20) {
//          System.out.println("输入长度过大");
            return false;
        }
        Boolean b = checkRegister(loginName);
        if (b == null || !b) {
//          System.out.println("用户已注册");
            return false;
        }
        String s = StringUtils.checkStringType(loginName);
        User user = new User();
        user.setUname(uname);
        user.setPassword(password);

        if (StringUtils.TEL_STRING.equals(s)) {
            user.setTel(loginName);

        } else if (StringUtils.EMAIL_STRING.equals(s)) {
            user.setEmail(loginName);
        }
        try {
            int result = userMapper.insertSelective(user);
//          System.out.println("插入结果：" + result);
            if (result != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return null;
        }
    }
}

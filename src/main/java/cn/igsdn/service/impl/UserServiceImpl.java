package cn.igsdn.service.impl;

import cn.igsdn.dao.UserMapper;
import cn.igsdn.domain.User;
import cn.igsdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Pattern;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    String MATCH_MOBILE = "^1[3456789]\\d{9}$";
    String MATCH_EMAIL = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    public Object login(int type, String loginName, String password) {
        switch (type) {
            case 0:
                return null;
            case 1: {
                return userMapper.selectGenUserDTOByPrimaryKey(loginName, password);
            }
        }
        return null;
    }

    public String isEmailOrTel(String LoginName){
        String result = null;
        if(Pattern.matches(MATCH_MOBILE,LoginName)){
            result = "mobile";
        }else if(Pattern.matches(MATCH_EMAIL,LoginName)){
            result = "email";
        }
        return result;
    }

    public Boolean checkRegister(String LoginName) {
        boolean result= false;
        try{

            if(Pattern.matches(MATCH_MOBILE,LoginName)||Pattern.matches(MATCH_EMAIL,LoginName)){

                int i = userMapper.selectByLoginName(LoginName);
                System.out.println(i);
                if(i==0){
                    result = false;//
                }else if(i==1){
                    result = true;
                }
        }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean register(Map<String, String> map) {
        int result = 0;
        User user= new User();
            user.setUname(map.get("Uname"));
            user.setPassword(map.get("Password1"));
            String s = isEmailOrTel(map.get("Loginname"));
            if("mobile".equals(s)){
                user.setTel(map.get("Loginname"));

            }else if("email".equals(s)){
                user.setEmail(map.get("Loginname"));
            }
            try {
                result = userMapper.insertSelective(user);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println(result);
            if (result != 0) {
                return true;
            } else {
                return false;
            }


    }
}

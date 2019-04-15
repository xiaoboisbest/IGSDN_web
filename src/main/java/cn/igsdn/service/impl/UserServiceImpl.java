package cn.igsdn.service.impl;

import cn.igsdn.dao.UserMapper;
import cn.igsdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

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
}

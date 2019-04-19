package cn.igsdn.service;

import java.util.Map;

public interface UserService {
    public Object login(int Type, String loginName, String password);
    // 检查是否注册过
    public Boolean checkRegister(String LocalName);
    // register
    public Boolean register(Map<String,String> map);
}

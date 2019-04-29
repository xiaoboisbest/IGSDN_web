package cn.igsdn.service;

public interface UserService {
    // 登陆
    public Object login(int Type, String loginName, String password);

    // 检查登录名
    public Boolean checkRegister(String loginName);

    // 注册
    public Boolean register(String loginName, String password, String uname);
}

package cn.igsdn.service;

import cn.igsdn.domain.DocumentComment2;
import cn.igsdn.dto.GenUserInfo;
import cn.igsdn.dto.GenUserInformation;

import java.util.List;
import java.util.Map;

public interface UserService {

    public Object login(int Type, String loginName, String password);

    public Boolean checkPasswordByPrimaryKey(Integer userId, String password);

    public Boolean checkRegister(String loginName);

    public Boolean register(String loginName, String password, String uname);

    public Boolean updatePassword(Integer userId, String password1, String passWord2);

    public Boolean isLoginNameMatchPassword(String loginName, String password1);

    public GenUserInfo selectUserInfo(String loginName);

    Boolean updateUserInfo(String loginName, String gender, String age, String name, String uname);

    List<GenUserInformation> selectUserInformation(String loginName);

    Boolean updateInformationState(String userInformationID, String state);

    Boolean deleteUserInformation(Integer id);

    Map<String, List> selectAllRemark(Integer id);


    Boolean insertInformationRemark1(DocumentComment2 documentComment2);

    Boolean insertInformationRemark2(Integer ID, String receive);
}

package cn.igsdn.service;

import cn.igsdn.domain.DocumentComment2;
import cn.igsdn.dto.GenUserInfo;
import cn.igsdn.dto.GenUserInformation;
import cn.igsdn.dto.UserMemoryInfoDTO;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserMemoryInfoDTO selectUserMemoryInfoByUserId(Integer userId);

    Boolean updateLoginNameByPrimaryKey(Integer userId, String tel, String email);

    Long countUnReadUserInformationByUserId(Integer userId);

    Object login(int Type, String loginName, String password);

    Boolean checkPasswordByPrimaryKey(Integer userId, String password);

    Boolean checkRegister(String loginName);

    Boolean register(String loginName, String password, String uname);

    Boolean updatePassword(Integer userId, String password1, String passWord2);

    Boolean isLoginNameMatchPassword(String loginName, String password1);

    GenUserInfo selectUserInfo(Integer userId);

    Boolean updateUserInfo(Integer userId, String gender, String age, String name, String uname);

    List<GenUserInformation> selectUserInformation(String loginName);

    Boolean updateInformationState(String userInformationID, String state);

    Boolean deleteUserInformation(Integer id);

    Map<String, List> selectAllRemark(Integer id);

    Boolean insertInformationRemark1(DocumentComment2 documentComment2);

    Boolean insertInformationRemark2(Integer ID, String receive);

}

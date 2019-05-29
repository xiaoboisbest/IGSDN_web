package cn.igsdn.dao;

import cn.igsdn.domain.*;
import cn.igsdn.dto.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserMapper {
    GenUserDTO selectGenUserDTOByPrimaryKey(String loginName, String password) throws DataAccessException;

    int updatePasswordByLoginName(String LoginName, String PassWord2);

    int selectLoginNameAndPassword(String loginName, String password1);

    long countByExample(UserExample example);

    List<GenUserInformation> selectUserInformationByLoginName(String loginName);


    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id) throws DataAccessException;

    Long insert(User record) throws DataAccessException;

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int selectByLoginName(String LoginName) throws DataAccessException;

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateUserInfoByLoginName(String loginName, String gender, String age, String name, String uname);

    int updateByPrimaryKey(User record) throws DataAccessException;

    GenUserInfo selectUserInfoByLoginName(String loginName);

    Integer updateInformationStateByID(String userInformationID, String state);

    Integer deleteUserInformationByID(Integer id);

    UserInformation selectUserInformationByID(Integer ID);

    DocumentCommentDTO selectDocumentComments(Integer commentsId);

    DocumentComment2DTO selectDocumentComments2(Integer commentsId);
}
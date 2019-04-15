package cn.igsdn.dao;

import cn.igsdn.domain.User;
import cn.igsdn.domain.UserExample;
import cn.igsdn.dto.GenUserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    GenUserDTO selectGenUserDTOByPrimaryKey(String loginName, String password);

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
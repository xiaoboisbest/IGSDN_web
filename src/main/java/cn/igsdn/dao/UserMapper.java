package cn.igsdn.dao;

import cn.igsdn.domain.User;
import cn.igsdn.domain.UserExample;
import cn.igsdn.dto.GenUserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserMapper {
    GenUserDTO selectGenUserDTOByPrimaryKey(String loginName, String password) throws DataAccessException;

    long countByExample(UserExample example);

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

    int updateByPrimaryKey(User record) throws DataAccessException;
}
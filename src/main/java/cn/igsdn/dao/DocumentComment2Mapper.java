package cn.igsdn.dao;

import cn.igsdn.domain.DocumentComment2;
import cn.igsdn.domain.DocumentComment2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocumentComment2Mapper {
    long countByExample(DocumentComment2Example example);

    int deleteByExample(DocumentComment2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(DocumentComment2 record);

    int insertSelective(DocumentComment2 record);

    List<DocumentComment2> selectByExample(DocumentComment2Example example);

    DocumentComment2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DocumentComment2 record, @Param("example") DocumentComment2Example example);

    int updateByExample(@Param("record") DocumentComment2 record, @Param("example") DocumentComment2Example example);

    int updateByPrimaryKeySelective(DocumentComment2 record);

    int updateByPrimaryKey(DocumentComment2 record);
}
package cn.igsdn.dao;

import cn.igsdn.domain.DocumentFormat;
import cn.igsdn.domain.DocumentFormatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentFormatMapper {
    long countByExample(DocumentFormatExample example);

    int deleteByExample(DocumentFormatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DocumentFormat record);

    int insertSelective(DocumentFormat record);

    List<DocumentFormat> selectByExampleWithBLOBs(DocumentFormatExample example);

    List<DocumentFormat> selectByExample(DocumentFormatExample example);

    DocumentFormat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DocumentFormat record, @Param("example") DocumentFormatExample example);

    int updateByExampleWithBLOBs(@Param("record") DocumentFormat record, @Param("example") DocumentFormatExample example);

    int updateByExample(@Param("record") DocumentFormat record, @Param("example") DocumentFormatExample example);

    int updateByPrimaryKeySelective(DocumentFormat record);

    int updateByPrimaryKeyWithBLOBs(DocumentFormat record);

    int updateByPrimaryKey(DocumentFormat record);
}
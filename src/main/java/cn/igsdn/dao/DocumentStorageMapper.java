package cn.igsdn.dao;

import cn.igsdn.domain.DocumentStorage;
import cn.igsdn.domain.DocumentStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentStorageMapper {
    long countByExample(DocumentStorageExample example);

    int deleteByExample(DocumentStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DocumentStorage record);

    int insertSelective(DocumentStorage record);

    List<DocumentStorage> selectByExampleWithBLOBs(DocumentStorageExample example);

    List<DocumentStorage> selectByExample(DocumentStorageExample example);

    DocumentStorage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DocumentStorage record, @Param("example") DocumentStorageExample example);

    int updateByExampleWithBLOBs(@Param("record") DocumentStorage record, @Param("example") DocumentStorageExample example);

    int updateByExample(@Param("record") DocumentStorage record, @Param("example") DocumentStorageExample example);

    int updateByPrimaryKeySelective(DocumentStorage record);

    int updateByPrimaryKeyWithBLOBs(DocumentStorage record);

    int updateByPrimaryKey(DocumentStorage record);
}
package cn.igsdn.dao;

import cn.igsdn.domain.DocumentComment;
import cn.igsdn.domain.DocumentCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentCommentMapper {
    long countByExample(DocumentCommentExample example);

    int deleteByExample(DocumentCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DocumentComment record);

    int insertSelective(DocumentComment record);

    List<DocumentComment> selectByExample(DocumentCommentExample example);

    DocumentComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DocumentComment record, @Param("example") DocumentCommentExample example);

    int updateByExample(@Param("record") DocumentComment record, @Param("example") DocumentCommentExample example);

    int updateByPrimaryKeySelective(DocumentComment record);

    int updateByPrimaryKey(DocumentComment record);
}
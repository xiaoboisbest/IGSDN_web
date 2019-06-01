package cn.igsdn.service;

import cn.igsdn.domain.DocumentComment;
import cn.igsdn.domain.DocumentComment2;
import cn.igsdn.dto.SimpleDocumentCommentDTO;
import cn.igsdn.utils.PageHelper;
import cn.igsdn.utils.TreeNode;

import java.util.List;

public interface DocumentCommentsService {
    public TreeNode<SimpleDocumentCommentDTO> getDocumentCommentsTree(List<DocumentComment> list, Integer userID);
    public List<DocumentComment2> listDocumentComments2ByPrimaryKey(Integer id, Boolean isSecond);
    public PageHelper computeDocumentCommentsTotalPage(Integer documentID, Integer pageNum, Integer userID);

    Boolean insertComments(DocumentComment2 documentComment2);

    Boolean insertCommentsToUserInfo(Integer documentCommentId, Integer autoID);

    Boolean remarkDocument(DocumentComment documentComment);
    public Boolean insertRemarkDocumentToUserInfo(Integer documentID, Integer autoID);
}

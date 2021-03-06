package cn.igsdn.utils;

import cn.igsdn.domain.DocumentComment;
import cn.igsdn.domain.DocumentComment2;
import cn.igsdn.dto.SimpleDocumentCommentDTO;

import java.text.DateFormat;
import java.util.List;

public class DocumentCommentUtils {
    public static SimpleDocumentCommentDTO documentCommentToSimpleDocumentCommentDTO(Integer userID, String userName, Object o) {
        SimpleDocumentCommentDTO simpleDocumentCommentDTO = new SimpleDocumentCommentDTO();
        if (o instanceof DocumentComment) {
            DocumentComment documentComment = (DocumentComment) o;
            if (userID.equals(documentComment.getCommentator())) {
                userName = "您";
            } else {
                userName = documentComment.getIdentify() ? "匿名" : userName;
            }
            simpleDocumentCommentDTO.setLevelShow(false);
            simpleDocumentCommentDTO.setUserName(userName);
            simpleDocumentCommentDTO.setForeignKey(documentComment.getDocument());
            simpleDocumentCommentDTO.setContent(documentComment.getContent());
            simpleDocumentCommentDTO.setId(documentComment.getId());
            simpleDocumentCommentDTO.setRemarkDate(DateFormat.getDateInstance().format(documentComment.getRemarkDate()));

        } else if (o instanceof DocumentComment2) {
            DocumentComment2 documentComment = (DocumentComment2) o;
            simpleDocumentCommentDTO.setId(documentComment.getId());
            userName = documentComment.getIsIdentify() ? "匿名" : userName;
            if (userID.equals(documentComment.getCommentator())) {
                userName = "您";
            }
            simpleDocumentCommentDTO.setUserName(userName);
            simpleDocumentCommentDTO.setRemarkDate(DateFormat.getDateInstance().format(documentComment.getRemarkDate()));
            simpleDocumentCommentDTO.setContent(documentComment.getContent());
            simpleDocumentCommentDTO.setForeignKey(documentComment.getCommentId());
        }
        return simpleDocumentCommentDTO;
    }

    public static void documentCommentWriteInList(List<TreeNode> list, Integer userID, String userName, Object o) {
        SimpleDocumentCommentDTO simpleDocumentCommentDTO = DocumentCommentUtils.documentCommentToSimpleDocumentCommentDTO(userID, userName, o);
        TreeNode node = new TreeNode();
        node.setData(simpleDocumentCommentDTO);
        list.add(node);
    }

}

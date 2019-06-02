package cn.igsdn.service.impl;

import cn.igsdn.dao.*;
import cn.igsdn.domain.*;
import cn.igsdn.dto.SimpleDocumentCommentDTO;
import cn.igsdn.service.DocumentCommentsService;
import cn.igsdn.utils.DocumentCommentUtils;
import cn.igsdn.utils.PageHelper;
import cn.igsdn.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("documentCommentsService")
public class DocumentCommentsServiceImpl implements DocumentCommentsService {
    @Autowired
    DocumentComment2Mapper documentComment2Mapper;
    @Autowired
    DocumentCommentMapper documentCommentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInformationMapper userInformationMapper;
    @Autowired
    DocumentMapper documentMapper;

    public TreeNode<SimpleDocumentCommentDTO> getDocumentCommentsTree(List<DocumentComment> list, Integer userID) {
        TreeNode<SimpleDocumentCommentDTO> root = new TreeNode<>();
        List<TreeNode> firstChildren = new ArrayList<>();
        List<TreeNode> others = new ArrayList<>();

        list.forEach(item -> {
            User user = userMapper.selectByPrimaryKey(item.getCommentator());
            DocumentCommentUtils.documentCommentWriteInList(firstChildren, userID, user.getUname(), item);
        });
        root.setChildren(firstChildren);
        firstChildren.forEach(item -> {
            List<DocumentComment2> dc_list2 = listDocumentComments2ByPrimaryKey(((SimpleDocumentCommentDTO) item.getData()).getId(), true);
            List<TreeNode> children = new ArrayList<>();
            dc_list2.forEach(item2 -> {
                User user = userMapper.selectByPrimaryKey(item2.getCommentator());
                DocumentCommentUtils.documentCommentWriteInList(children, userID, user.getUname(), item2);
            });
            others.addAll(children);
            item.setChildren(children);
        });
        boolean isFound = true;
        while (isFound) {
            List<TreeNode> temp = new ArrayList<>();
            others.forEach(item -> {
                List<TreeNode> children = new ArrayList<>();
                List<DocumentComment2> li = listDocumentComments2ByPrimaryKey(((SimpleDocumentCommentDTO) item.getData()).getId(), false);
                li.forEach(item2 -> {
                    User user = userMapper.selectByPrimaryKey(item2.getCommentator());
                    DocumentCommentUtils.documentCommentWriteInList(children, userID, user.getUname(), item2);
                });
                temp.addAll(children);
                item.setChildren(children);
            });
            if (temp.size() == 0) {
                isFound = false;
                break;
            }
            others.clear();
            others.addAll(temp);
        }
        return root;
    }

    public List<DocumentComment2> listDocumentComments2ByPrimaryKey(Integer id, Boolean isSecond) {
        DocumentComment2Example example = new DocumentComment2Example();
        DocumentComment2Example.Criteria criteria = example.createCriteria();
        criteria.andIsSecondEqualTo(isSecond);
        criteria.andCommentIdEqualTo(id);
        return documentComment2Mapper.selectByExample(example);
    }

    public PageHelper computeDocumentCommentsTotalPage(Integer userID, Integer documentID, Integer pageNum, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        List<DocumentComment> list = documentCommentMapper.selectByDocumentForPage(documentID, (pageNum - 1) * pageSize, pageSize);
        TreeNode tree = getDocumentCommentsTree(list, userID);
        pageHelper.setData(tree.getChildren());
        DocumentCommentExample example = new DocumentCommentExample();
        DocumentCommentExample.Criteria criteria = example.createCriteria();
        criteria.andDocumentEqualTo(documentID);
        pageHelper.setTotal(documentCommentMapper.countByExample(example));
        pageHelper.setCurrentPage(pageNum);
        return pageHelper;
    }

    @Override
    public Boolean insertComments(DocumentComment2 documentComment2) {
        System.out.println(documentComment2.toString());
        //先往
        if (documentComment2Mapper.insertSelective(documentComment2) != 0) {
            //documentComments2 已经插入
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertCommentsToUserInfo(Integer userId, Integer autoID) {
       // DocumentComment2 documentComment2 = documentComment2Mapper.selectByPrimaryKey(Integer.valueOf(documentCommentId));
        UserInformation userInformation = new UserInformation();
        userInformation.setReceiver(userId);
        userInformation.setCommentsId(autoID);
        short source = 2;
        userInformation.setSource(source);
        short state = 1;
        userInformation.setState(state);
        if (userInformationMapper.insertSelective(userInformation) != 0)
            return true;
        return false;
    }

    @Override
    public Boolean remarkDocument(DocumentComment documentComment) {
        if (documentCommentMapper.insertSelective(documentComment) != 0) {
            //documentComments2 已经插入

            return true;
        }
        return false;
    }

    @Override
    public Boolean insertRemarkDocumentToUserInfo(Integer documentID, Integer autoID) {
        Document document = documentMapper.selectByPrimaryKey(documentID);
        UserInformation userInformation = new UserInformation();
        userInformation.setReceiver(document.getUploader());
        userInformation.setCommentsId(autoID);
        short source = 1;
        userInformation.setSource(source);
        short state = 1;
        userInformation.setState(state);
        if (userInformationMapper.insertSelective(userInformation) != 0)
            return true;
        return false;
    }

}

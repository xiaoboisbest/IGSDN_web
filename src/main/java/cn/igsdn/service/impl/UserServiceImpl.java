package cn.igsdn.service.impl;

import cn.igsdn.dao.DocumentComment2Mapper;
import cn.igsdn.dao.DocumentMapper;
import cn.igsdn.dao.UserInformationMapper;
import cn.igsdn.dao.UserMapper;
import cn.igsdn.domain.*;
import cn.igsdn.dto.*;
import cn.igsdn.service.UserService;
import cn.igsdn.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    DocumentComment2Mapper documentComment2Mapper;
    @Autowired
    UserInformationMapper userInformationMapper;
    @Autowired
    DocumentMapper documentMapper;

    @Override
    public UserMemoryInfoDTO selectUserMemoryInfoByUserId(Integer userId) {
        UserMemoryInfoDTO userMemoryInfoDTO = new UserMemoryInfoDTO();
        DecimalFormat df = new DecimalFormat("#.00");
        Double percentUsedMemory = userMapper.selectPercentUsedMemory(userId);
        String percentUsedMemoryString = df.format(userMapper.selectPercentUsedMemory(userId));
        userMemoryInfoDTO.setPercentUsedMemory(percentUsedMemoryString);
        DocumentExample example1 = new DocumentExample();
        DocumentExample example2 = new DocumentExample();
        DocumentExample.Criteria criteria1 = example1.createCriteria();
        DocumentExample.Criteria criteria2 = example2.createCriteria();
        criteria1.andUploaderEqualTo(userId);
        criteria2.andUploaderEqualTo(userId);
        userMemoryInfoDTO.setDocumentTotal(documentMapper.countByExample(example1));
        criteria1.andIsPublicEqualTo(true);
        userMemoryInfoDTO.setPublicDocumentTotal(documentMapper.countByExample(example1));
        criteria2.andIsPublicEqualTo(false);
        userMemoryInfoDTO.setPrivateDocumentTotal(documentMapper.countByExample(example2));

        Long memorySize = userMapper.selectByPrimaryKey(userId).getMemorySize();
        System.out.println(StringUtils.formatDocumentSize(memorySize));

        userMemoryInfoDTO.setTotalMemory(StringUtils.formatDocumentSize(memorySize));
        Double remainingMemory = (100 - percentUsedMemory) * memorySize / 100;
        System.out.println(remainingMemory);
        userMemoryInfoDTO.setRemainingMemory(StringUtils.formatDocumentSize(remainingMemory));
        System.out.println(StringUtils.formatDocumentSize((100 - percentUsedMemory) * memorySize));
        return userMemoryInfoDTO;
    }

    @Override
    public Boolean updateLoginNameByPrimaryKey(Integer userId, String tel, String email) {
        if (!StringUtils.isNotBlank(tel))
            tel = null;
        if (!StringUtils.isNotBlank(email))
            email = null;
        User user = new User();
        user.setId(userId);
        user.setTel(tel);
        user.setEmail(email);
        int res = userMapper.updateByPrimaryKeySelective(user);
        if (res > 0)
            return true;
        else
            return false;
    }

    @Override
    public Long countUnReadUserInformationByUserId(Integer userId) {
        UserInformationExample example = new UserInformationExample();
        UserInformationExample.Criteria criteria = example.createCriteria();
        criteria.andReceiverEqualTo(userId);
        return userInformationMapper.countByExample(example);
    }

    @Override
    public Boolean isLoginNameMatchPassword(String loginName, String password1) {
        try {
            if (userMapper.selectLoginNameAndPassword(loginName, password1) != 0)
                return true;
        } catch (Exception e) {
            return null;
        }
        return false;
    }

    @Override
    public GenUserInfo selectUserInfo(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        GenUserInfo genUserInfo = new GenUserInfo();
        genUserInfo.setAge(user.getAge());
        genUserInfo.setTel(user.getTel());
        genUserInfo.setEmail(user.getEmail());
        genUserInfo.setGender(user.getGender());
        genUserInfo.setName(user.getName());
        genUserInfo.setUname(user.getUname());
        return genUserInfo;
    }

    @Override
    public Boolean updateUserInfo(Integer userId, String gender, String age, String name, String uname) {
        User user = new User();
        user.setId(userId);
        if ("男".equals(gender)) {
            user.setGender(Boolean.TRUE);
        } else if ("女".equals(gender)) {
            user.setGender(Boolean.FALSE);
        }
        user.setAge(age);
        user.setName(name);
        user.setUname(uname);
        System.out.println(user);
        int result = userMapper.updateByPrimaryKeySelective(user);
        if (result > 0) {
            return true;
        }
        return false;
    }


    @Override
    public List<GenUserInformation> selectUserInformation(String loginName) {
        //loginName为ig_user ：ID
        return userMapper.selectUserInformationByLoginName(loginName);

    }

    @Override
    public Boolean updateInformationState(String userInformationID, String state) {
        return userMapper.updateInformationStateByID(userInformationID, state) != 0 ? true : false;
    }

    @Override
    public Boolean deleteUserInformation(Integer id) {
        return userMapper.deleteUserInformationByID(id) != 0 ? true : false;
    }

    @Override
    public Boolean updatePassword(Integer userId, String password1, String passWord2) {
        if (checkPasswordByPrimaryKey(userId, password1)) {
            User user = new User();
            user.setPassword(passWord2);
            user.setId(userId);
            int res = userMapper.updateByPrimaryKeySelective(user);
            System.out.println(res);
            if (res < 0)
                return true;
            else
                return false;
        }
        return null;
    }

    @Override
    public Map<String, List> selectAllRemark(Integer id) {
        Map<String, List> bigMap = new HashMap<>();
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        UserInformation information = userMapper.selectUserInformationByID(id);
        DocumentCommentDTO documentComment;
        if (information.getSource() == 1) {
            documentComment = userMapper.selectDocumentComments(information.getCommentsId());
            list1.add(documentComment);
        } else {
            DocumentComment2DTO documentComment2 = userMapper.selectDocumentComments2(information.getCommentsId());
            list2.add(documentComment2);
            while (!(documentComment2.getSecond())) {
                documentComment2 = userMapper.selectDocumentComments2(documentComment2.getCommentId());
                list2.add(documentComment2);
            }
            //
            documentComment2 = userMapper.selectDocumentComments2(documentComment2.getCommentId());
            documentComment = userMapper.selectDocumentComments(documentComment2.getCommentId());
            list1.add(documentComment);
        }
        bigMap.put("list1", list1);
        bigMap.put("list2", list2);

        return bigMap;
    }

    @Override
    public Boolean insertInformationRemark1(DocumentComment2 documentComment2) {
        try {
            Integer result = documentComment2Mapper.insertSelective(documentComment2);
            if (result != 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean insertInformationRemark2(Integer ID, String receive) {
        try {
            UserInformation userInformation = new UserInformation();
            userInformation.setCommentsId(ID);
            userInformation.setReceiver(Integer.valueOf(receive));
            short source = 2;
            userInformation.setSource(source);
            short state = 1;
            userInformation.setState(state);
            if (userInformationMapper.insertSelective(userInformation) != 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Object login(int type, String loginName, String password) {
        try {
            switch (type) { // 登陆方式（0：管理员；1：普通用户）
                case 0:
                    return null;
                case 1: {
                    return userMapper.selectGenUserDTOByPrimaryKey(loginName, password);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public Boolean checkPasswordByPrimaryKey(Integer userId, String password) {
        String password1 = userMapper.selectByPrimaryKey(userId).getPassword();
        if (password1.equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkRegister(String loginName) {
        try {
            if (StringUtils.isloginName(loginName)) {
                System.out.println("===========");
                int result = userMapper.selectByLoginName(loginName);
                if (result != 0) {
                    return false; // 用户名重复，不可注册
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            return null;
            //e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean register(String loginName, String password, String uname) {
        System.out.println(loginName + "" + password + "-------" + uname);
        if (!StringUtils.isNotBlank(loginName) || !StringUtils.isNotBlank(uname) || !StringUtils.isNotBlank(password)) {
//          System.out.println("输入为空");
            return false;
        }
        System.out.println(loginName + "" + password + "-------" + uname);
        if (uname.trim().length() > 10 || password.trim().length() > 20) {
//          System.out.println("输入长度过大");
            return false;
        }
        System.out.println(loginName + "" + password + "-------" + uname);
        Boolean b = checkRegister(loginName);
        System.out.println(b);
        if (b == null || !b) {
            //System.out.println("用户已注册");
            return false;
        }
        String s = StringUtils.checkStringType(loginName);
        User user = new User();
        user.setUname(uname);
        user.setPassword(password);

        if (StringUtils.TEL_STRING.equals(s)) {
            user.setTel(loginName);

        } else if (StringUtils.EMAIL_STRING.equals(s)) {
            user.setEmail(loginName);
        }
        try {
            int result = userMapper.insertSelective(user);
//          System.out.println("插入结果：" + result);
            if (result != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return null;
        }
    }
}

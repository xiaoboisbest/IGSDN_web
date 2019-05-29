package cn.igsdn.test;

import cn.igsdn.dao.DocumentComment2Mapper;
import cn.igsdn.dao.UserMapper;
import cn.igsdn.domain.DocumentComment2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.Date;

/**
 * 对 dao 层的功能进行测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperText {
@Autowired
    UserMapper userMapper;
@Autowired
DocumentComment2Mapper d;
    @Test
    public void textCrud() throws ParseException {
        //System.out.println(userMapper.selectLoginNameAndPassword("3","1"));
        //System.out.println(new UserServiceImpl().updatePassword("3", "1", "123456"));
        //System.out.println(userMapper.selectUserInfoByLoginName("3").getName()+"=========");
        //<!--updateUserInfoByLoginName(String loginName, String gender, String age, String name, String uname);-->
        //System.out.println(userMapper.updateUserInfoByLoginName("3","0","18","董小姐","大嘴"));
        //System.out.println(userMapper.selectUserInformationByLoginName("3"));
        /*
            this.id = id;
        this.content = content;
        this.isIdentify = isIdentify;
        this.commentator = commentator;
        this.commentId = commentId;
        this.isSecond = isSecond;
        this.remarkDate = remarkDate;
        this.document = document;
         */
       /* List<GenUserInformation> list  = userMapper.selectUserInformationByLoginName("3");
        for(GenUserInformation l:list){
            System.out.println(l.toString());
        }
        id=null, content='213dasd', isIdentify=false, commentator=3, commentId=4, isSecond=false, remarkDate=Wed May 22 08:00:00 CST 2019, document=1}
Creating a new SqlSession
*/
       Date date = new Date();

        DocumentComment2 documentComment2 = new DocumentComment2(null,"213dasd",false,3,4,false,null,1);
        d.insertSelective(documentComment2);
        System.out.println(documentComment2.getId()+"======================");
    }
}

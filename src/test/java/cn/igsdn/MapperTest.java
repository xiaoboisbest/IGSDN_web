package cn.igsdn;

import cn.igsdn.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试dao层
 * <p>
 * 1. 导入spring单元测试(Spring-Test)
 * 2. @ContextConfiguration指定Spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    UserService userService;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD() {
//        GenUserDTO genUserDTO = (GenUserDTO) userService.login(1,"3@gmail.com","123456");
//        System.out.println(genUserDTO);
        Object o = userService.login(1,"3@gmail.com","123456");
        //1. 创建IoC容器
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 从容器中获得mapper
        //context.getBean(CategoryMapper.class);
        //3.测试

        //插入
//                departmentMapper.insertSelective(new Department(null, "开发部"));
//                departmentMapper.insertSelective(new Department(null, "测试部"));
        //删除
//                departmentMapper.deleteByPrimaryKey(1);
        //修改
//                departmentMapper.updateByPrimaryKey(new Department(2, "开发部"));
        //查询

//        List<SimpleCategroyDTO> list = categoryMapper.selectSimpleByExample();
//
//        for (SimpleCategroyDTO e : list) {
//            System.out.println(e);
//        }

        //employeeMapper.insertSelective(new Employee(null, "Cat", "F", "Cat@qq.com", 2));

        //批量插入
//                EmployeeMapper employeeMapper2 = sqlSession.getMapper(EmployeeMapper.class);
//                for(int i = 0; i < 1000; i++) {
//                        String uid = UUID.randomUUID().toString().substring(0, 5) + i;
//                        employeeMapper2.insertSelective(new Employee(null, uid, (i % 2 == 0) ? "M" : "F", uid + "@qq.com",2));
//                }


    }
}

//package cn.igsdn;
//
//
//import com.github.pagehelper.PageInfo;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
///**
// * 使用Spring测试模块提供的测试请求功能
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath:applicationContext.xml", "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
//public class MVCTest {
//    @Autowired
//    WebApplicationContext context;
//    //虚拟mvc请求，获得处理结果
//    MockMvc mockMvc;
//
//    @Before
//    public void initMockMvc() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void testPage() throws Exception {
//        //模拟请求，拿到返回值
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pageNum", "1")).andReturn();
//        //请求成功后，请求域中会有pageInfo
//        MockHttpServletRequest request = result.getRequest();
//        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
//        System.out.println("当前页码：" + pageInfo.getPageNum());
//        System.out.println("总页码：" + pageInfo.getPages());
//        System.out.println("总记录数：" + pageInfo.getTotal());
//        System.out.println("在页面需要连续显示的页码：");
//        for (int i : pageInfo.getNavigatepageNums()) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//    }
//}

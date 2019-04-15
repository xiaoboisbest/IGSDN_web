//package cn.igsdn.service.impl;
//
//import cn.igsdn.dao.CategoryMapper;
//import cn.igsdn.dto.SimpleCategroyDTO;
//import cn.igsdn.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("categoryService")
//public class CategoryServiceImpl implements CategoryService {
//    @Autowired
//    CategoryMapper categoryMapper;
//
//    public List<SimpleCategroyDTO> listSimpleCategories() {
//        return categoryMapper.selectSimpleByExample();
//    }
//}

package cn.igsdn.service.impl;

import cn.igsdn.dao.CategoryMapper;
import cn.igsdn.domain.Category;
import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryIntroDTO getCategoryIntroByPrimaryKey(Integer id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        CategoryIntroDTO categoryIntroDTO = new CategoryIntroDTO();
        categoryIntroDTO.setId(id);
        categoryIntroDTO.setName(category.getName());
        categoryIntroDTO.setIntro(category.getIntro());
        return categoryIntroDTO;
    }
}

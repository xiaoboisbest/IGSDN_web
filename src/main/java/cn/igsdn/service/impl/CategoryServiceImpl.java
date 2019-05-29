package cn.igsdn.service.impl;

import cn.igsdn.dao.CategoryMapper;
import cn.igsdn.domain.Category;
import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.domain.CategoryExample;
import cn.igsdn.service.CategoryService;
import cn.igsdn.utils.CategoryTreeNode;
import cn.igsdn.utils.CategoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<CategoryTreeNode> listSimpleCategories() {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        List<Category> list = categoryMapper.selectByExample(categoryExample);

        List<CategoryTreeNode> result = new ArrayList<>();
        CategoryTreeNode categoryTreeNode = CategoryUtils.simpleCategoriesFormat(list,"knowledge-");
        CategoryTreeNode categoryTreeNode1 = CategoryUtils.simpleCategoriesFormat(list,"knowledge-private-");
        result.add(categoryTreeNode);
        result.add(categoryTreeNode1);
        return result;
    }

}

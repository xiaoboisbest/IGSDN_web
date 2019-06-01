package cn.igsdn.service.impl;

import cn.igsdn.dao.CategoryMapper;
import cn.igsdn.domain.Category;
import cn.igsdn.domain.CategoryExample;
import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.dto.CategoryTreeNodeDTO;
import cn.igsdn.service.CategoryService;
import cn.igsdn.utils.TreeNode;
import cn.igsdn.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    public List<List<CategoryTreeNodeDTO>> getCategoryTree(Integer categoryId) {
        if (categoryId == null) {
            CategoryExample categoryExample = new CategoryExample();
            List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
            List<TreeNode<String>> dataList = new LinkedList<>();
            for (Category category : categoryList) {
                TreeNode<String> treeNode = new TreeNode<>();
                treeNode.setIndex(category.getId());
                treeNode.setLevel(category.getLevel());
                treeNode.setParents(category.getParents());
                treeNode.setData(category.getName());
                dataList.add(treeNode);
            }
            List<String> preList = new LinkedList<>();
            preList.add("knowledge-");
            preList.add("knowledge-private-");
            List<List<CategoryTreeNodeDTO>> resultLists = new TreeUtils<String, CategoryTreeNodeDTO>().generateTreesByArrays(CategoryTreeNodeDTO.class, dataList, preList);
            resultLists.remove(0);
            return resultLists;
        }
        return null;
    }

}

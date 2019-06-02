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

    public List<List<CategoryTreeNodeDTO>> getCategoryTree(Integer categoryId, List<String> preList) {
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
            List<List<CategoryTreeNodeDTO>> resultLists = new TreeUtils<String, CategoryTreeNodeDTO>().generateTreesByArrays(CategoryTreeNodeDTO.class, dataList, preList);
            if (preList != null && preList.size() != 0)
                resultLists.remove(0);
            return resultLists;
        }
        return null;
    }

    public List<Integer> listAllCategory(Integer categoryId) {
        List<Integer> temp1 = new LinkedList<>();
        List<Integer> temp2 = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        temp1.add(categoryId);
        result.add(categoryId);
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();

        while (temp1.size() > 0 || temp2.size() > 0) {
            if (temp1.size() > 0) {
                listAllCategoryHelper(temp1, temp2, result, example);
            } else {
                listAllCategoryHelper(temp2, temp1, result, example);
            }
        }
        return result;
    }

    /**
     * 遍历temp1中的id，放入result中，查询所有children并加入到temp2中，清空temp1
     *
     * @param temp1
     * @param temp2
     * @param result
     * @param example
     */
    protected void listAllCategoryHelper(List<Integer> temp1, List<Integer> temp2, List<Integer> result, CategoryExample example) {
        for (Integer id : temp1) {
            example.getOredCriteria().get(0).andParentsEqualTo(id);
            List<Category> categoryList = categoryMapper.selectByExample(example);
            for (Category category : categoryList) {
                temp2.add(category.getId());
                result.add(category.getId());
            }
        }
        temp1.clear();
    }
}

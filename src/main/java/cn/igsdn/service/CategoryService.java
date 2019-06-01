package cn.igsdn.service;

import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.dto.CategoryTreeNodeDTO;

import java.util.List;

public interface CategoryService {
    public CategoryIntroDTO getCategoryIntroByPrimaryKey(Integer id);

    public List<List<CategoryTreeNodeDTO>> getCategoryTree(Integer categoryId);
}

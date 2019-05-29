package cn.igsdn.service;

import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.dto.SimpleCategroyDTO;

import java.util.List;

public interface CategoryService {
    public CategoryIntroDTO getCategoryIntroByPrimaryKey(Integer id);
}

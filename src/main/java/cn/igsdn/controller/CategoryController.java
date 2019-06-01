package cn.igsdn.controller;


import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.dto.CategoryTreeNodeDTO;
import cn.igsdn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "getCategoryIntro/{id}", method = RequestMethod.GET)
    public CategoryIntroDTO getCategoryIntro(@PathVariable Integer id) {
        return categoryService.getCategoryIntroByPrimaryKey(id);
    }

    @RequestMapping(value = "/getAllCategoryTree", method = RequestMethod.GET)
    public List<List<CategoryTreeNodeDTO>> getAllCategoryTree() {
        return categoryService.getCategoryTree(null);
    }
}

package cn.igsdn.controller;


import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.dto.CategoryTreeNodeDTO;
import cn.igsdn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
//@CrossOrigin(origins = "http://localhost:8081")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "getCategoryIntro/{id}", method = RequestMethod.GET)
    public CategoryIntroDTO getCategoryIntro(@PathVariable Integer id) {
        return categoryService.getCategoryIntroByPrimaryKey(id);
    }

    @RequestMapping(value = "/getAllCategoryTree", method = RequestMethod.POST)
    public List<List<CategoryTreeNodeDTO>> getAllCategoryTree(@RequestBody Map<String, List<String>> map) {
        List<String> preList = map.get("preList");
        return categoryService.getCategoryTree(null, preList);

    }
}

package cn.igsdn.controller;

import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "getCategoryIntro/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CategoryIntroDTO getCategoryIntro(@PathVariable Integer id) {
        return categoryService.getCategoryIntroByPrimaryKey(id);
    }
}

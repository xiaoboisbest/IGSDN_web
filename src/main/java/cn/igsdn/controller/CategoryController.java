package cn.igsdn.controller;

import cn.igsdn.dto.CategoryIntroDTO;
import cn.igsdn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.igsdn.service.CategoryService;
import cn.igsdn.utils.CategoryTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "getCategoryIntro/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CategoryIntroDTO getCategoryIntro(@PathVariable Integer id) {
        return categoryService.getCategoryIntroByPrimaryKey(id);

    /*  Gson gson = new Gson();*/
    @ResponseBody
    @RequestMapping(value = "/listSimpleCategories", method = RequestMethod.GET/*, produces = "text/plain;charset=UTF-8"*/)
    public List<CategoryTreeNode> listSimpleCategories() {
        return categoryService.listSimpleCategories();
    }
}

package cn.igsdn.controller;

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

    /*  Gson gson = new Gson();*/
    @ResponseBody
    @RequestMapping(value = "/listSimpleCategories", method = RequestMethod.GET/*, produces = "text/plain;charset=UTF-8"*/)
    public List<CategoryTreeNode> listSimpleCategories() {

        return categoryService.listSimpleCategories();
    }
}

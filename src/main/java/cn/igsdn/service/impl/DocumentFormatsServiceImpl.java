package cn.igsdn.service.impl;

import cn.igsdn.dao.CategoryMapper;
import cn.igsdn.dao.DocumentFormatMapper;
import cn.igsdn.domain.Category;
import cn.igsdn.domain.CategoryExample;
import cn.igsdn.domain.DocumentFormat;
import cn.igsdn.domain.DocumentFormatExample;
import cn.igsdn.service.DocumentFormatsService;
import cn.igsdn.utils.CategoryTreeNode2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("documentFormatsService")
public class DocumentFormatsServiceImpl implements DocumentFormatsService {
    @Autowired
    DocumentFormatMapper documentFormatMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<String> selectDocumentFormatNameBySuffix(String s) {
        DocumentFormatExample documentFormatExample = new DocumentFormatExample();
        DocumentFormatExample.Criteria criteria = documentFormatExample.createCriteria();
        criteria.andSuffixEqualTo(s);
        List<DocumentFormat> list = documentFormatMapper.selectByExample(documentFormatExample);
        String name = null;
        Integer id =null;

        for (DocumentFormat df : list) {
            name = df.getName();
            id = df.getId();
        }

        List<String> stringList =new ArrayList<>();
        System.out.println("=========="+name+"==="+id);
        stringList.add(id+"");
        stringList.add(name);
        return stringList;
    }

    @Override
    public CategoryTreeNode2 selectDocumentCategories() {
        //获取全部Category
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        List<Category> list = categoryMapper.selectByExample(categoryExample);

        List<CategoryTreeNode2> firstChildren = new ArrayList<>();
        List<CategoryTreeNode2> secondChildren = new ArrayList<>();

        CategoryTreeNode2 root = new CategoryTreeNode2();
        Integer i = 1;
        list.forEach(item->{

            if(i.equals(item.getLevel())){
                CategoryTreeNode2 node = new CategoryTreeNode2();
                node.setValue(item.getId().toString());
                node.setLabel(item.getName());
                firstChildren.add(node);
                secondChildren.addAll(firstChildren);
            }
        });
        root.setChildren(firstChildren);
        Boolean flag = true;
        while(flag){
            List<CategoryTreeNode2> other = new ArrayList<>();
            secondChildren.forEach(item->{
                other.clear();
                list.forEach(item2->{
                    if(item.getValue().equals(item2.getParents().toString())){
                        CategoryTreeNode2 node =  new CategoryTreeNode2();
                        node.setValue(item2.getId().toString());
                        node.setLabel(item2.getName());
                        other.add(node);
                    }

                });
                if(other.size()!=0){
                    item.setChildren(other);
                }
            });
            if(other.size()==0){
                flag = false;
                break;
            }
            secondChildren.clear();
            secondChildren.addAll(other);
        }
        return root;
    }
}

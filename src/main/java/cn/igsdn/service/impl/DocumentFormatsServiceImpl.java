package cn.igsdn.service.impl;

import cn.igsdn.dao.CategoryMapper;
import cn.igsdn.dao.DocumentFormatMapper;
import cn.igsdn.domain.DocumentFormat;
import cn.igsdn.domain.DocumentFormatExample;
import cn.igsdn.service.DocumentFormatsService;
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
        stringList.add(id+"");
        stringList.add(name);
        return stringList;
    }
    
}

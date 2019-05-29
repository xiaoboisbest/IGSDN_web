package cn.igsdn.service;

import cn.igsdn.utils.CategoryTreeNode2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentFormatsService {
    public List<String> selectDocumentFormatNameBySuffix(String s);

    CategoryTreeNode2 selectDocumentCategories();
}

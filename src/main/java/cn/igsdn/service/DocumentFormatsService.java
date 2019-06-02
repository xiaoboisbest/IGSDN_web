package cn.igsdn.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentFormatsService {
    public List<String> selectDocumentFormatNameBySuffix(String s);
}

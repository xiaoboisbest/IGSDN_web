package cn.igsdn.service;

import cn.igsdn.dto.DocumentDTO;
import cn.igsdn.dto.SimpleDocumentDTO;
import cn.igsdn.utils.PageHelper;

import java.util.Map;

public interface DocumentService {
    public PageHelper<SimpleDocumentDTO> getDocumentPage(String type, Map<String, String> map);

    public String getDocumentFormatIconBase4ByPrimaryKey(Integer formatId);

    public DocumentDTO getDocumentDetailsByPrimaryKey(Integer documentId);

}

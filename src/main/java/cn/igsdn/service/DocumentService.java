package cn.igsdn.service;

import cn.igsdn.domain.Document;
import cn.igsdn.dto.DocumentDTO;
import cn.igsdn.dto.DocumentDTO2;
import cn.igsdn.dto.SimpleDocumentDTO;
import cn.igsdn.utils.PageHelper;

import java.util.Map;

public interface DocumentService {
    PageHelper<SimpleDocumentDTO> getDocumentPage(String type, Map<String, String> map);

    String getDocumentFormatIconBase4ByPrimaryKey(Integer formatId);

    DocumentDTO getDocumentDetailsByPrimaryKey(Integer documentId);

    DocumentDTO2 getDocumentDetailsBeforeUpdateByPrimaryKey(Integer documentId);

    Boolean insertDocument(Document document);

    Boolean deleteDocumentByPrimaryKey(Integer documentId);

    Boolean updateDocumentByPrimaryKey(Document document);

}

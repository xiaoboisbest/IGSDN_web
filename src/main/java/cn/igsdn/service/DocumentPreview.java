package cn.igsdn.service;

import java.util.List;

public interface DocumentPreview {
    public List<String> documentOnlinePreview(String documentId, String documentType, String documentUrl, String pageNum, String pageSize);

    public List<String> officeDocumentOnlinePreview(int documentId, String documentUrl, int pageNum, int pageSize);

    public List<String> pdfDocumentOnlinePreview(int documentId, String documentUrl, int pageNum, int pageSize);

    public List<String> markdownDocumentOnlinePreview(String documentUrl);

    public String getMarkdownContent(Integer documentId);

    public Boolean updateMarkdownContent(Integer documentId, String content);

}

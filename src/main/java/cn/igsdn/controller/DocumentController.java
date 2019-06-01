package cn.igsdn.controller;

import cn.igsdn.dto.DocumentDTO;
import cn.igsdn.dto.SimpleDocumentDTO;
import cn.igsdn.service.DocumentPreview;
import cn.igsdn.service.DocumentService;
import cn.igsdn.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class DocumentController {

    @Autowired
    DocumentPreview documentPreview;

    @Autowired
    DocumentService documentService;


    @RequestMapping(value = "updateMarkdownContent/{id}", method = RequestMethod.PUT)
    public Boolean updateMarkdownContent(@PathVariable Integer id, @RequestBody Map<String, String> map) {
        String content = map.get("content");
        return documentPreview.updateMarkdownContent(id, content);
    }

    @RequestMapping(value = "getMarkdownContent/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String getMarkdownContent(@PathVariable Integer id) {
        return documentPreview.getMarkdownContent(id);
    }

    @RequestMapping(value = "getDocumentDetails/{id}", method = RequestMethod.GET)
    public DocumentDTO getDocumentDetails(@PathVariable Integer id) {
        return documentService.getDocumentDetailsByPrimaryKey(id);
    }

    @RequestMapping(value = "listDocumentByScroll", method = RequestMethod.POST)
    public List<SimpleDocumentDTO> listDocumentByScroll(@RequestBody Map<String, String> map) {
        return documentService.getDocumentPage("public", map).getData();
    }

    @RequestMapping(value = "listDocumentByPagination", method = RequestMethod.POST)
    public PageHelper<SimpleDocumentDTO> listDocumentByPagination(@RequestBody Map<String, String> map) {
        return documentService.getDocumentPage("private", map);
    }

    @RequestMapping(value = "getDocumentFormatIcon/{id}", method = RequestMethod.GET)
    public String getDocumentFormatIcon(@PathVariable Integer id) {
        return documentService.getDocumentFormatIconBase4ByPrimaryKey(id);
    }

    @RequestMapping(value = "documentOnlinePreview", method = RequestMethod.POST)
    public List<String> documentOnlinePreview(@RequestBody Map<String, String> map) {
        String documentId = map.get("documentId");
        String documentType = map.get("documentType");
        String documentUrl = map.get("documentUrl");
        String pageNum = map.get("pageNum");
        String pageSize = map.get("pageSize");
        List<String> res = documentPreview.documentOnlinePreview(documentId, documentType, documentUrl, pageNum, pageSize);
        return res;
    }


}
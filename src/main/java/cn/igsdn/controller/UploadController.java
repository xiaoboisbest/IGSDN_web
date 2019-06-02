package cn.igsdn.controller;

import cn.igsdn.domain.Document;
import cn.igsdn.service.DocumentFormatsService;
import cn.igsdn.service.DocumentService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UploadController {
    @Autowired
    DocumentFormatsService documentFormatsService;

    @Autowired
    DocumentService documentService;

    @RequestMapping(value = "/getDocumentFormatName", method = RequestMethod.POST)
    public List<String> selectDocumentFormatName(@RequestBody Map<String, String> map) {
        String suffix = map.get("suffix");
        System.out.println(suffix + "================");
        return documentFormatsService.selectDocumentFormatNameBySuffix(suffix);
    }

    @RequestMapping(value = "/uploadFile")
    public Boolean uploadFile(@RequestBody Map<String, String> map) {
        //name,size,file,photoBase64,key1,key2,key3,intro,isPublic,formatId,uploader,category
        String documentString = map.get("document");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        Document document = null;
        try {
            document = objectMapper.readValue(documentString, Document.class);
            return documentService.insertDocument(document);
            /**
             * 1.上传的filebase64 在  document.getSrc()
             * 2.上传的imgbase64 在  document.getIconSrc()
             * 3.上传日期 null
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

package cn.igsdn.controller;

import cn.igsdn.domain.Document;
import cn.igsdn.service.DocumentFormatsService;
import cn.igsdn.utils.CategoryTreeNode2;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
public class UploadController {
    @Autowired
    DocumentFormatsService documentFormatsService;

    @RequestMapping(value = "/getDocumentFormatName", method = RequestMethod.POST)
    @ResponseBody
    public List<String> selectDocumentFormatName(@RequestBody Map<String, String> map) {
        String suffix = map.get("suffix");
        System.out.println(suffix + "================");
        return documentFormatsService.selectDocumentFormatNameBySuffix(suffix);
    }

    @ResponseBody
    @RequestMapping(value = "/getDocumentCategories", method = RequestMethod.GET)
    public CategoryTreeNode2 getDocumentCategories() {
        return documentFormatsService.selectDocumentCategories();
    }

    @RequestMapping(value = "/img")
    public void getImg() {

    }
    @ResponseBody
    @RequestMapping(value = "/uploadFile")
    public Boolean uploadFile(@RequestBody Map<String, String> map) {
        //name,size,file,photoBase64,key1,key2,key3,intro,isPublic,formatId,uploader,category
        String documentString = map.get("document");
        System.out.println(documentString);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        Document document = null;
        try {

            document = objectMapper.readValue(documentString, Document.class);

            /**
             * 1.上传的filebase64 在  document.getSrc()
             * 2.上传的imgbase64 在  document.getIconSrc()
             * 3.上传日期 null
             */

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}

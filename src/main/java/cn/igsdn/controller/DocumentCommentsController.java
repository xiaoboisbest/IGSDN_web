package cn.igsdn.controller;

import cn.igsdn.domain.DocumentComment;
import cn.igsdn.domain.DocumentComment2;
import cn.igsdn.service.DocumentCommentsService;
import cn.igsdn.service.UserService;
import cn.igsdn.utils.PageHelper;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class DocumentCommentsController {
    @Autowired
    DocumentCommentsService documentCommentsService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/listDocumentComments")
    public PageHelper listDocumentComments(@RequestBody Map<String, Integer> map) {
        Integer documentId = map.get("documentId");
        Integer pageNum = map.get("pageNum");
        return documentCommentsService.computeDocumentCommentsTotalPage(documentId, pageNum, 3);
    }

    @RequestMapping(value = "/replyDocumentComments")
    public Boolean replyDocumentComments(@RequestBody Map<String, String> map) {
        String documentComment2String = map.get("documentComment2");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        try {
            DocumentComment2 documentComment2 = objectMapper.readValue(documentComment2String, DocumentComment2.class);
            if (userService.insertInformationRemark1(documentComment2)) {
                if (documentCommentsService.insertCommentsToUserInfo(documentComment2.getCommentId(), documentComment2.getId()))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/remarkDocument")
    public Boolean remarkDocument(@RequestBody Map<String, String> map) {
        String documentCommentString = map.get("document");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        try {
            DocumentComment documentComment = objectMapper.readValue(documentCommentString, DocumentComment.class);
            Integer documentID = documentComment.getDocument();
            if (documentCommentsService.remarkDocument(documentComment))
                if (documentCommentsService.insertRemarkDocumentToUserInfo(documentID, documentComment.getId()))
                    return true;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }


}

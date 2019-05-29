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
@ResponseBody
public class DocumentCommentsController {
    @Autowired
    DocumentCommentsService documentCommentsService;
@Autowired
    UserService userService;

    @RequestMapping(value = "/listDocumentComments/")
    public PageHelper listDocumentComments(@RequestBody Map<String,Integer> map) {
        Integer documentID =map.get("documentID");
        Integer pageNum = map.get("pageNum");
        //Integer documentID, Integer pageNum, Integer userID
        return documentCommentsService.computeDocumentCommentsTotalPage(1, pageNum, 3);
    }
    @RequestMapping(value="/replyDocumentComments")
    public Boolean replyDocumentComments(@RequestBody Map<String,String> map){
        /*
         * documentCommentId, message,isSecond,userID
         */
        String documentComment2String = (String) map.get("documentComment2");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        DocumentComment2 documentComment2 = null;
        try {
            documentComment2 = objectMapper.readValue(documentComment2String, DocumentComment2.class);
            System.out.println(documentComment2.getRemarkDate()+"=================================");
            if(userService.insertInformationRemark1(documentComment2)){
                if(documentCommentsService.insertCommentsToUserIofo(documentComment2.getCommentId(),documentComment2.getId()))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(documentComment2.getId()+"====================");

        return false ;
    }

    @RequestMapping(value="/remarkDocument")
    public Boolean remarkDocument(@RequestBody Map<String,String> map){
        String documentCommentString = (String) map.get("document");
        System.out.println(documentCommentString+"=-=-=-=-=-=-=-=");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        DocumentComment documentComment = null;
        try {
            documentComment = objectMapper.readValue(documentCommentString, DocumentComment.class);
            Integer documentID =documentComment.getDocument();
           /* System.out.println(documentComment.toString()+"=======================");*/
            System.out.println(documentComment.getRemarkDate()+"=================================");
            if(documentCommentsService.remarkDocument(documentComment))
            if(documentCommentsService.insertremarkDocumentToUserIofo(documentID,documentComment.getId()))
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        }



        return false ;
    }


}

package cn.igsdn.test;

import cn.igsdn.domain.DocumentComment;

import java.util.ArrayList;
import java.util.List;

public class text {
    public static void main(String[] args) {
        DocumentComment documentComment = new DocumentComment();
        documentComment.setId(1);
        List<DocumentComment> a = new ArrayList<DocumentComment>();
        a.add(documentComment);

        List<DocumentComment> b = new ArrayList<DocumentComment>();
        b.addAll(a);
        for(DocumentComment c:b){
            c.setId(2);
        }

        for(DocumentComment c:a){
            System.out.println(c.getId());
        }
    }
}

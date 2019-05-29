package cn.igsdn.domain;

import java.util.Date;

public class DocumentComment2 {
    private Integer id;

    private String content;

    private Boolean isIdentify;

    private Integer commentator;

    private Integer commentId;

    private Boolean isSecond;

    private Date remarkDate;

    private Integer document;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIsIdentify() {
        return isIdentify;
    }

    public void setIsIdentify(Boolean isIdentify) {
        this.isIdentify = isIdentify;
    }

    public Integer getCommentator() {
        return commentator;
    }

    public void setCommentator(Integer commentator) {
        this.commentator = commentator;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Boolean getIsSecond() {
        return isSecond;
    }

    public void setIsSecond(Boolean isSecond) {
        this.isSecond = isSecond;
    }

    public Date getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(Date remarkDate) {
        this.remarkDate = remarkDate;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public DocumentComment2() {
    }

    public DocumentComment2(Integer id, String content, Boolean isIdentify, Integer commentator, Integer commentId, Boolean isSecond, Date remarkDate, Integer document) {
        this.id = id;
        this.content = content;
        this.isIdentify = isIdentify;
        this.commentator = commentator;
        this.commentId = commentId;
        this.isSecond = isSecond;
        this.remarkDate = remarkDate;
        this.document = document;
    }

    @Override
    public String toString() {
        return "DocumentComment2{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isIdentify=" + isIdentify +
                ", commentator=" + commentator +
                ", commentId=" + commentId +
                ", isSecond=" + isSecond +
                ", remarkDate=" + remarkDate +
                ", document=" + document +
                '}';
    }
}
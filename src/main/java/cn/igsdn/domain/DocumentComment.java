package cn.igsdn.domain;

import java.util.Date;

public class DocumentComment {
    private Integer id;

    private String content;

    private Boolean isIdentify;

    private Integer commentator;

    private Integer document;
    private Date remarkDate;

    public Boolean getIdentify() {
        return isIdentify;
    }

    public void setIdentify(Boolean identify) {
        isIdentify = identify;
    }

    public Date getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(Date remarkDate) {
        this.remarkDate = remarkDate;
    }

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

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "DocumentComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isIdentify=" + isIdentify +
                ", commentator=" + commentator +
                ", document=" + document +
                ", remarkDate=" + remarkDate +
                '}';
    }
}
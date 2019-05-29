package cn.igsdn.dto;

public class DocumentComment2DTO {
    private Integer id;

    private String content;

    private Boolean isIdentify;

    private Integer commentator;

    private Integer commentId;

    private Boolean isSecond;

    private String remarkDate;

    private Integer document;
    private String commentatorName;
    private String documentName;

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
        this.content = content;
    }

    public Boolean getIdentify() {
        return isIdentify;
    }

    public void setIdentify(Boolean identify) {
        isIdentify = identify;
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
    public String getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(String remarkDate) {
        this.remarkDate = remarkDate;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Boolean getSecond() {
        return isSecond;
    }

    public void setSecond(Boolean second) {
        isSecond = second;
    }

    @Override
    public String toString() {
        return "DocumentComment2DTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isIdentify=" + isIdentify +
                ", commentator=" + commentator +
                ", commentId=" + commentId +
                ", isSecond=" + isSecond +
                ", remarkDate=" + remarkDate +
                ", document=" + document +
                ", commentatorName='" + commentatorName + '\'' +
                ", documentName='" + documentName + '\'' +
                '}';
    }
}

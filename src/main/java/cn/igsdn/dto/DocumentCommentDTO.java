package cn.igsdn.dto;

public class DocumentCommentDTO {
    private Integer id;

    private String content;

    private Boolean isIdentify;

    private Integer commentator;
    private Integer document;
    private String commentatorName;
    private String documentName;
    private String remarkDate;

    public String getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(String remarkDate) {
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

    @Override
    public String toString() {
        return "DocumentCommentDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isIdentify=" + isIdentify +
                ", commentator=" + commentator +
                ", document=" + document +
                ", commentatorName='" + commentatorName + '\'' +
                ", documentName='" + documentName + '\'' +
                ", remarkDate=" + remarkDate +
                '}';
    }
}

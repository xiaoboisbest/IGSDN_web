package cn.igsdn.dto;

import java.util.Date;

/**
 * 文件评论DTO
 */
public class SimpleDocumentCommentDTO {
    private Integer id;
    private String content;
    private String userName;
    private Integer foreignKey; // 外键
    private String remarkDate;
    private Boolean levelShow;

    public Boolean getLevelShow() {
        return levelShow;
    }

    public void setLevelShow(Boolean levelShow) {
        this.levelShow = levelShow;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(Integer foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(String remarkDate) {
        this.remarkDate = remarkDate;
    }

    public SimpleDocumentCommentDTO() {
    }

    public SimpleDocumentCommentDTO(Integer id, String content, String userName, Integer foreignKey, String remarkDate) {
        this.id = id;
        this.content = content;
        this.userName = userName;
        this.foreignKey = foreignKey;
        this.remarkDate = remarkDate;
    }

    @Override
    public String toString() {
        return "SimpleDocumentCommentDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", foreignKey=" + foreignKey +
                ", remarkDate=" + remarkDate +
                '}';
    }
}

package cn.igsdn.dto;

/**
 * 用户通知信息
 */
public class GenUserInformation {

    private Integer ID;
    private Integer state;

    private Integer is_dentify;
    private String userName;
    private String content;
    private String documentName;
    private String remark_date;
    private Integer source;
    private Integer dc_id;

    public Integer getDc_id() {
        return dc_id;
    }

    public void setDc_id(Integer dc_id) {
        this.dc_id = dc_id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    private Integer userID;
    private Integer documentID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIs_dentify() {
        return is_dentify;
    }

    public void setIs_dentify(Integer is_dentify) {
        this.is_dentify = is_dentify;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getRemark_date() {
        return remark_date;
    }

    public void setRemark_date(String remark_date) {
        this.remark_date = remark_date;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    @Override
    public String toString() {
        return "GenUserInformation{" +
                "ID=" + ID +
                ", state=" + state +
                ", is_dentify=" + is_dentify +
                ", userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                ", documentName='" + documentName + '\'' +
                ", remark_date='" + remark_date + '\'' +
                ", source=" + source +
                ", dc_id=" + dc_id +
                ", userID=" + userID +
                ", documentID=" + documentID +
                '}';
    }
}

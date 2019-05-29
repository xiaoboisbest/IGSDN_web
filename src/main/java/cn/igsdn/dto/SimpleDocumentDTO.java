package cn.igsdn.dto;

import java.util.Date;

public class SimpleDocumentDTO {
    private Integer id;
    private String name;
    private String intro; // 20个字符
    private String uploaderName;
    private String lastUpdateTime;
    private String size;
    private String uploadTime;
    private Integer icon;
    private String downloadNum;

    public SimpleDocumentDTO() {
    }

    public SimpleDocumentDTO(Integer id, String name, String intro, String uploaderName, String size, String uploadTime, String lastUpdateTime, Integer icon) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.uploaderName = uploaderName;
        this.size = size;
        this.uploadTime = uploadTime;
        this.lastUpdateTime = lastUpdateTime;
        this.icon = icon;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(String downloadNum) {
        this.downloadNum = downloadNum;
    }

    @Override
    public String toString() {
        return "SimpleDocumentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", uploaderName='" + uploaderName + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", size='" + size + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", icon=" + icon +
                '}';
    }
}

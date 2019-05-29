package cn.igsdn.domain;

public class DocumentFormat {
    private Integer id;
    private String name;
    private String suffix;

    private String defaultIconSrc;

    private String intro;

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

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public String getDefaultIconSrc() {
        return defaultIconSrc;
    }

    public void setDefaultIconSrc(String defaultIconSrc) {
        this.defaultIconSrc = defaultIconSrc == null ? null : defaultIconSrc.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}
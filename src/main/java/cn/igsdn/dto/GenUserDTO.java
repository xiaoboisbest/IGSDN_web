package cn.igsdn.dto;

/**
 * 普通用户DTO类
 */
public class GenUserDTO {
    private Integer id;

    private String uname;

    private Short genUserLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Short getGenUserLevel() {
        return genUserLevel;
    }

    public void setGenUserLevel(Short genUserLevel) {
        this.genUserLevel = genUserLevel;
    }

    @Override
    public String toString() {
        return "GenUserDTO{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", genUserLevel=" + genUserLevel +
                '}';
    }
}

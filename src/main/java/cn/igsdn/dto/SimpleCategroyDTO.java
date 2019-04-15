package cn.igsdn.dto;

public class SimpleCategroyDTO {
    private Integer id;

    private String name;

    private Integer level;

    private Integer parents;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParents() {
        return parents;
    }

    public void setParents(Integer parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "SimpleCategroyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parents=" + parents +
                '}';
    }
}

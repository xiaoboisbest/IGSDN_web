package cn.igsdn.dto;

public class SimpleCategoryDTO {
    private Integer id;
    private String name;
    private Integer level;
    private Integer parents;

    public SimpleCategoryDTO(Integer id, String name, Integer level, Integer parents) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.parents = parents;
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
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

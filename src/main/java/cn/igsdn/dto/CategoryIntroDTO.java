package cn.igsdn.dto;

public class CategoryIntroDTO {
    private Integer id;

    private String name;

    private String intro;

    public CategoryIntroDTO() {
    }

    public CategoryIntroDTO(Integer id, String name, String intro) {
        this.id = id;
        this.name = name;
        this.intro = intro;
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

}

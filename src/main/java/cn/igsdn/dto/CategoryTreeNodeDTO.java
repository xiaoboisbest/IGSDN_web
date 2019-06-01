package cn.igsdn.dto;

import java.util.List;

public class CategoryTreeNodeDTO implements Cloneable {
    private String index;
    private String title;
    private List<CategoryTreeNodeDTO> subs;

    public CategoryTreeNodeDTO() {
    }

    public CategoryTreeNodeDTO(String index, String title, List<CategoryTreeNodeDTO> subs) {
        this.index = index;
        this.title = title;
        this.subs = subs;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategoryTreeNodeDTO> getSubs() {
        return subs;
    }

    public void setSubs(List<CategoryTreeNodeDTO> subs) {
        this.subs = subs;
    }

    @Override
    public String toString() {
        return "CategoryTreeNodeDTO{" +
                "index='" + index + '\'' +
                ", title='" + title + '\'' +
                ", subs=" + subs +
                '}';
    }
}

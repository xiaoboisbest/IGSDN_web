package cn.igsdn.utils;

import java.util.List;

public class CategoryTreeNode {
    private String index;

    private String title;


    private List<CategoryTreeNode> subs;

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



    public List<CategoryTreeNode> getSubs() {
        return subs;
    }

    public void setSubs(List<CategoryTreeNode> subs) {
        this.subs = subs;
    }
}

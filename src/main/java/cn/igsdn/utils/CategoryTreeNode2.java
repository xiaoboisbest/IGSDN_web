package cn.igsdn.utils;

import java.util.List;

public class CategoryTreeNode2 {
    private String value;
    private String label;
    private List<CategoryTreeNode2> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CategoryTreeNode2> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTreeNode2> children) {
        this.children = children;
    }
}

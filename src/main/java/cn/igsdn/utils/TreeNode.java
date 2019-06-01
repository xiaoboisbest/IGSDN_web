package cn.igsdn.utils;

import java.util.List;

public class TreeNode<T> {
    private Integer index;
    private T data;
    private Integer level;
    private Integer parents;

    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(Integer index, T data, Integer level, Integer parents, List<TreeNode> children) {
        this.index = index;
        this.data = data;
        this.level = level;
        this.parents = parents;
        this.children = children;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getParents() {
        return parents;
    }

    public void setParents(Integer parents) {
        this.parents = parents;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", children=" + children +
                '}';
    }
}

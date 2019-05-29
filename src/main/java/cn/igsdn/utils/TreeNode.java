package cn.igsdn.utils;

import java.util.List;

public class TreeNode<T> {
    private T node;
    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(T node, List<TreeNode> children) {
        this.node = node;
        this.children = children;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
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
                "node=" + node +
                ", children=" + children +
                '}';
    }
}

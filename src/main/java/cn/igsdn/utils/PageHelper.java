package cn.igsdn.utils;

import cn.igsdn.dto.SimpleDocumentCommentDTO;

public class PageHelper {


    private long total;
    private Integer currentPage;
    private TreeNode<SimpleDocumentCommentDTO> tree;


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public TreeNode<SimpleDocumentCommentDTO> getTree() {
        return tree;
    }

    public void setTree(TreeNode<SimpleDocumentCommentDTO> tree) {
        this.tree = tree;
    }
}

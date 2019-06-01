package cn.igsdn.test;

import cn.igsdn.dto.CategoryTreeNodeDTO;
import cn.igsdn.utils.TreeUtils;
import cn.igsdn.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<TreeNode<String>> list = new LinkedList<>();
        list.add(new TreeNode(1, "编程语言", 1, 0, null));
        list.add(new TreeNode(2, "java", 2, 1, null));
        list.add(new TreeNode(3, "c", 2, 1, null));
        list.add(new TreeNode(4, "c#", 2, 1, null));
        list.add(new TreeNode(5, "数据结构", 1, 0, null));
        list.add(new TreeNode(6, "图", 2, 5, null));
        list.add(new TreeNode(7, "二叉树", 3, 6, null));
        List<String> preList = new ArrayList<>();
        preList.add("private");

        List<List<CategoryTreeNodeDTO>> resultLists = new TreeUtils().generateTreesByArrays(CategoryTreeNodeDTO.class, list, preList);
        System.out.println(resultLists.size());
        for (List<CategoryTreeNodeDTO> resultList : resultLists) {
            System.out.println(resultList.size());
            for (CategoryTreeNodeDTO result : resultList) {
                System.out.println("children size" + result.getSubs().size());
                System.out.println(result);
            }
        }

    }
}

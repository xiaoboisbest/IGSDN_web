package cn.igsdn.utils;

import cn.igsdn.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CategoryUtils {


    public static CategoryTreeNode simpleCategroyIntoTree(List<Category> list) {
        CategoryTreeNode root = new CategoryTreeNode();

        List<CategoryTreeNode> firstChildren = new ArrayList<>();
        List<CategoryTreeNode> secondChildren = new ArrayList<>();
        list.forEach(item -> {
            if (item.getLevel() == 1) {
                //System.out.println("=====");
                CategoryTreeNode node = new CategoryTreeNode();

                node.setTitle(item.getName());
                node.setIndex(item.getId().toString());
                firstChildren.add(node);
                secondChildren.addAll(firstChildren);
            }
        });
        list.removeAll(firstChildren);
        root.setSubs(firstChildren);
        Boolean flag = true;
        while (flag) {
            List<CategoryTreeNode> ortherChildren = new ArrayList<>();

            secondChildren.forEach(item -> {
                ortherChildren.clear();
                list.forEach(item2 -> {

                    if ((item2.getParents().toString()).equals(item.getIndex())) {
                        //System.out.println(item2.getParents().toString()+"==========="+item.getIndex());
                        CategoryTreeNode node = new CategoryTreeNode();
                        node.setTitle(item2.getName());
                        node.setIndex(item2.getId().toString());

                        ortherChildren.add(node);


                    }
                });
                if(ortherChildren.size()!=0) {
                    item.setSubs(ortherChildren);
                }
            });
            if (ortherChildren.size() == 0) {
                flag = false;
                //System.out.println("=====");
                break;
            }
            secondChildren.clear();
            secondChildren.addAll(ortherChildren);
        }


        return root;
    }

    public static CategoryTreeNode simpleCategoriesFormat(List list,String s) {
        List result = new ArrayList();
        CategoryTreeNode list1 = simpleCategroyIntoTree(list);
        Stack<CategoryTreeNode> stack = new Stack<>();
        stack.push(list1);
        while (!stack.isEmpty()) {
            CategoryTreeNode node = stack.pop();

            List<CategoryTreeNode> children = node.getSubs();
            if (children != null && !children.isEmpty()) {

                for (CategoryTreeNode child : children) {
                    child.setIndex(s + child.getIndex());
                    stack.push(child);

                }

            }
        }

        return list1;
    }
}

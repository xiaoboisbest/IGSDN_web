package cn.igsdn;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        add(1, list);
        System.out.println(list.size());
    }

    public static void add(Integer i, List<Integer> list){
        list.add(i);
    }
}

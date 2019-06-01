package cn.igsdn.utils;

import cn.igsdn.domain.Category;
import cn.igsdn.dto.CategoryTreeNodeDTO;
import cn.igsdn.dto.SimpleCategoryDTO;

import java.util.*;

/**
 * @param <D>
 * @param <T>
 */
public class TreeUtils<T, D> {

    /**
     * 给定结点集合和前缀集合生成多个树结构（0位置存放原结构树，其他位置存放增加后缀生成的树）
     *
     * @param dataList
     * @param preList
     * @return
     */
    public List<List<D>> generateTreesByArrays(Class clazz, List<TreeNode<T>> dataList, List<String> preList) {
        int preListSize = preList == null ? 0 : preList.size();
        List<List<D>> resultLists = new LinkedList<>();
        List<Map<Integer, D>> resultMaps = new LinkedList<>();
        int i = preListSize; // 用于遍历resultLists和resultMaps的索引
        resultLists.add(new ArrayList<>());
        resultMaps.add(new HashMap<>());
        // 根据preList的大小， 生成所有resultList和结果resultMap
        if (preListSize > 0) {
            while (i > 0) {
                List<D> resultList = new ArrayList<>();
                Map<Integer, D> resultMap = new HashMap();
                resultLists.add(resultList);
                resultMaps.add(resultMap);
                i--;
            }
        }

        // 遍历原集合
        for (TreeNode<T> treeNode : dataList) {
            Integer index;
            Integer parents;
            Integer level;
            T data = treeNode.getData();
            index = treeNode.getIndex();
            parents = treeNode.getParents();
            level = treeNode.getLevel();
            i = 0;
            while (i < resultLists.size()) {
                // clone数据
                D treeNodeDTO = null;
                Map<Integer, D> resultMap = resultMaps.get(i);
                if (clazz.equals(CategoryTreeNodeDTO.class)) {
                    String dataClone2 = (String) data;
                    CategoryTreeNodeDTO categoryTreeNodeDTO = new CategoryTreeNodeDTO();
                    if (i != 0)
                        categoryTreeNodeDTO.setIndex(new StringBuilder(preList.get(i - 1)).append(treeNode.getIndex()).toString());
                    else
                        categoryTreeNodeDTO.setIndex(treeNode.getIndex().toString());
                    categoryTreeNodeDTO.setSubs(new ArrayList<>());
                    categoryTreeNodeDTO.setTitle(dataClone2);
                    treeNodeDTO = (D) categoryTreeNodeDTO;
                    if (level != 1) { // 如果该结点不位于第一层，将其放入父节点的children数组中
                        ((CategoryTreeNodeDTO) resultMap.get(parents)).getSubs().add(categoryTreeNodeDTO);
                    } else {
                        resultLists.get(i).add(treeNodeDTO);
                    }
                }
                resultMap.put(index, treeNodeDTO);
                i++;
            }

        }
        return resultLists;
    }

}

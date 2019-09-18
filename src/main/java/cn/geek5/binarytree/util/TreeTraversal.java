package cn.geek5.binarytree.util;

import cn.geek5.binarytree.TreeNode;

import java.util.List;

/**
 * Author: CalcYu
 * Date: 2019/9/17
 */
public class TreeTraversal {

    //前序遍历
    public static void printTreeByNLR(TreeNode treeNode, List<Character> values) {
        values.add(treeNode.getValue());
        if (treeNode.getLeft() != null) {
            printTreeByNLR(treeNode.getLeft(), values);
        }
        if (treeNode.getRight() != null) {
            printTreeByNLR(treeNode.getRight(), values);
        }
    }

    //中序遍历
    public static void printTreeByLNR(TreeNode treeNode, List<Character> values) {
        if (treeNode.getLeft() != null) {
            printTreeByLNR(treeNode.getLeft(), values);
        }
        values.add(treeNode.getValue());
        if (treeNode.getRight() != null) {
            printTreeByLNR(treeNode.getRight(), values);
        }
    }


}

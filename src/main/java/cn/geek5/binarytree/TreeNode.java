package cn.geek5.binarytree;

import java.util.Map;

/**
 * Author: CalcYu
 * Date: 2019/9/17
 */
public class TreeNode {
    //值
    private Character value;
    //权重
    private int weight;
    //编码
    private String code = "";
    //父节点
    private TreeNode parent;
    //左子节点
    private TreeNode left;
    //右子节点
    private TreeNode right;

    public TreeNode(){

    }

    public TreeNode(Character value) {
        this.value = value;
    }

    public TreeNode(Character value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public String getCode() {
        return parent == null ? code : parent.getCode() + code;
    }


    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

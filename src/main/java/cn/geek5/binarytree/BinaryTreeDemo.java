package cn.geek5.binarytree;

import cn.geek5.binarytree.util.RandomTree;
import cn.geek5.binarytree.util.TreeTraversal;
import tech.vanyo.treePrinter.TreePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: CalcYu
 * Date: 2019/9/18
 */
public class BinaryTreeDemo {

    /**
     * 随机生成二叉树
     * 打印及遍历
     * @param args
     */
    public static void main(String[] args) {
        //随机生成二叉树
        TreeNode rootNode = RandomTree.randomTree(3);
        //打印树型结构
        TreePrinter<TreeNode> printer = new TreePrinter<>(n -> "" + n.getValue(), n -> n.getLeft(), n -> n.getRight());
        // set minimum horizontal spacing between node labels with setHspace
        printer.setHspace(1);
        // use square branches
        printer.setSquareBranches(false);
        printer.printTree(rootNode);
        System.out.println();
        List<Character> values = new ArrayList<>();
        //前序遍历
        TreeTraversal.printTreeByNLR(rootNode, values);
        System.out.println("前序遍历二叉树[NLR]:\t" + values.toString());
        values = new ArrayList<>();
        TreeTraversal.printTreeByLNR(rootNode, values);
        System.out.println("中序遍历二叉树[LNR]:\t" + values.toString());
    }
}

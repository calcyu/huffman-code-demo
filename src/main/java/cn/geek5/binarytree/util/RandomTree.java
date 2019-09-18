package cn.geek5.binarytree.util;

import cn.geek5.binarytree.TreeNode;

import java.util.Random;

/**
 * Author: CalcYu
 * Date: 2019/9/18
 */
public class RandomTree {

    private boolean isCreated() {
        Random random = new Random();
        return random.nextInt(100) > 30;
    }

    private char randomChar() {
        Random random = new Random();
        return (char) (random.nextInt(25) + 97);
    }

    private TreeNode createNode(TreeNode root, int level, int maxLevel) {
        //根据级别判断是否创建下一级
        if (level < maxLevel) {
            //随机生成左节点()
            if (isCreated()) {
                TreeNode left = new TreeNode(randomChar());
                root.setLeft(left);
                createNode(left, ++level, maxLevel);
                if (isCreated()) {
                    TreeNode right = new TreeNode(randomChar());
                    root.setRight(right);
                    createNode(right, ++level, maxLevel);
                }
            } else {
                TreeNode right = new TreeNode(randomChar());
                root.setRight(right);
                createNode(right, ++level, maxLevel);
            }
        }
        return root;
    }

    private TreeNode createRandomTree(int maxLevel) {
        Random random = new Random();
        TreeNode root = new TreeNode(randomChar());
        root = createNode(root, 0, 3);
        return root;
    }

    private static RandomTree instance;

    public static TreeNode randomTree(int maxLevel) {
        if (instance == null) {
            instance = new RandomTree();
        }
        return instance.createRandomTree(maxLevel);
    }

}

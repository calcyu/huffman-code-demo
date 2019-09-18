package cn.geek5.huffman;

import cn.geek5.binarytree.TreeNode;
import tech.vanyo.treePrinter.TreePrinter;

import java.util.*;

/**
 * Author: CalcYu
 * Date: 2019/9/16
 */
public class HuffmanTree {

    private static HuffmanTree instance;


    public static HuffmanTree getInstance() {
        if (instance == null) {
            instance = new HuffmanTree();
        }
        return instance;
    }

    private HuffmanTree(){

    }

    public static Map<Character, String> buildCode(TreeNode treeNode) {
        return getInstance().encodes(treeNode);
    }

    /**
     * 根据文本生成哈夫曼树
     *
     * @param text
     * @return
     */
    public static TreeNode createTree(String text) {
        HuffmanTree huffmanTree = new HuffmanTree();
        List<TreeNode> treeNodes = huffmanTree.createNodesByWeight(text);
        while (treeNodes.size() > 1) {
            TreeNode left = treeNodes.get(0);
            TreeNode right = treeNodes.get(1);
            TreeNode parent = new TreeNode(null, left.getWeight() + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);
            left.setParent(parent);
            right.setParent(parent);
            parent.getLeft().setCode("0");
            parent.getRight().setCode("1");
            treeNodes.remove(left);
            treeNodes.remove(right);
            treeNodes.add(0, parent);
            Collections.sort(treeNodes, new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                    return o1.getWeight() - o2.getWeight();
                }
            });
        }
        return treeNodes.get(0);
    }

    // 根据字符出现次数计算权值并生成结点
    private List<TreeNode> createNodesByWeight(String input) {
        List<TreeNode> treeNodes = new LinkedList<>();
        char[] chars = input.toCharArray();
        Map<Character, Integer> weightMap = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = weightMap.get(chars[i]);
            weightMap.put(chars[i], integer == null ? 1 : integer + 1);
        }
        for (Map.Entry<Character, Integer> entry : weightMap.entrySet()) {
            treeNodes.add(new TreeNode(entry.getKey(), entry.getValue()));
        }
        treeNodes.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        return treeNodes;
    }

    private void traversalTreeByNLR(TreeNode treeNode, Map<Character, String> codeMap) {
        if (treeNode.getValue() != null) {
            //叶子结点
            codeMap.put(treeNode.getValue(), treeNode.getCode());
        }
        if (treeNode.getLeft() != null) {
            traversalTreeByNLR(treeNode.getLeft(), codeMap);
        }
        if (treeNode.getRight() != null) {
            traversalTreeByNLR(treeNode.getRight(), codeMap);
        }
    }

    private Map<Character, String> encodes(TreeNode treeNode) {
        Map<Character, String> codeMap = new HashMap<>();
        traversalTreeByNLR(treeNode, codeMap);
        return codeMap;
    }

}
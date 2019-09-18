package cn.geek5.huffman;

import cn.geek5.binarytree.TreeNode;
import tech.vanyo.treePrinter.TreePrinter;

import java.util.Map;

/**
 * Author: CalcYu
 * Date: 2019/9/18
 */
public class HuffmanDemo {


    public static void main(String[] args) {
        HuffmanDemo demo = new HuffmanDemo();
        demo.printResult("This is a test paragraph.");
        demo.printResult("abcdefghijklmnopqrstuvwxyz");
    }


    public void printResult(String text) {
        String input = text;
        //根据重复次数，把重复次数设置为权重
        TreeNode treeNode = HuffmanTree.createTree(input);
        System.out.println("=========== Huffman tree ===========");
        //打印树型结构
        TreePrinter<TreeNode> printer = new TreePrinter<>(n -> {
            if (n.getValue() == null) {
                return n.getWeight() + "";
            }
            return "" + n.getValue();
        }, n -> n.getLeft(), n -> n.getRight());
        // set minimum horizontal spacing between node labels with setHspace
        printer.setHspace(1);
        // use square branches
        printer.setSquareBranches(false);
        printer.printTree(treeNode);
        System.out.println();
        System.out.println("=========== Print huffman code ===========");
        Map<Character,String> codeMap = HuffmanTree.buildCode(treeNode);
        for (Map.Entry<Character,String> entry:codeMap.entrySet()){
            System.out.println("char:" + entry.getKey() + ", code:" + entry.getValue());
        }
        System.out.println("=========== Encode Text ===========");
        System.out.println("原文内容:" + input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(codeMap.get(input.charAt(i)));
        }
        System.out.println("哈夫曼编码:" + sb.toString());
        System.out.println("二进制编码:" + toBinaryStr(input, ""));

    }

    public String toBinaryStr(String str, String separator) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]) + separator;
        }
        return result;
    }


}

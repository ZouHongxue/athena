package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouhongxue
 * @Date: 2019/3/19 8:55 PM
 */
public class BinaryTree {
    private int value;
    private BinaryTree leftTree;
    private BinaryTree rightTree;

    public BinaryTree() {
    }

    private BinaryTree(int value) {
        this.value = value;
    }

    public static BinaryTree getInitBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.value = 1;
        binaryTree.leftTree = new BinaryTree(2);
        binaryTree.rightTree = new BinaryTree(3);
        binaryTree.getLeftTree().setLeftTree(new BinaryTree(4));
        binaryTree.getLeftTree().setRightTree(new BinaryTree(5));
        binaryTree.getRightTree().setLeftTree(new BinaryTree(6));
        binaryTree.getRightTree().setRightTree(new BinaryTree(7));
        return binaryTree;
    }

    public static void printBinaryTree(BinaryTree binaryTree) {
        List<BinaryTree> binaryTrees = new ArrayList<>();
        if (null != binaryTree) {
            binaryTrees.add(binaryTree);
        } else {
            return;
        }
        List<BinaryTree> tmpBinaryTrees = new ArrayList<>();
        while (binaryTrees.size() > 0) {
            for (BinaryTree tree : binaryTrees) {
                System.out.print(tree.getValue() + "\t");
                if (null != tree.getLeftTree()) {
                    tmpBinaryTrees.add(tree.getLeftTree());
                }
                if (null != tree.getRightTree()) {
                    tmpBinaryTrees.add(tree.getRightTree());
                }
            }
            System.out.println();
            binaryTrees.clear();
            binaryTrees.addAll(tmpBinaryTrees);
            tmpBinaryTrees.clear();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(BinaryTree leftTree) {
        this.leftTree = leftTree;
    }

    public BinaryTree getRightTree() {
        return rightTree;
    }

    public void setRightTree(BinaryTree rightTree) {
        this.rightTree = rightTree;
    }
}

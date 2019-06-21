package data.structure.tree;

import model.BinaryTree;

/**
 * 镜像二叉树🌲
 * @Author: coffee
 */
public class BinaryTreeMirror {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getInitBinaryTree();
        BinaryTree.printBinaryTree(binaryTree);
        getMirrorTree(binaryTree);
        BinaryTree.printBinaryTree(binaryTree);
    }

    private static void getMirrorTree(BinaryTree binaryTree) {
        if (null != binaryTree && null != binaryTree.getLeftTree() && null != binaryTree.getRightTree()) {
            int tmp = binaryTree.getLeftTree().getValue();
            binaryTree.getLeftTree().setValue(binaryTree.getRightTree().getValue());
            binaryTree.getRightTree().setValue(tmp);
            getMirrorTree(binaryTree.getLeftTree());
            getMirrorTree(binaryTree.getRightTree());
        }
    }
}

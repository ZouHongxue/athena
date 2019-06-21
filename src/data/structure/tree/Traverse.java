package data.structure.tree;

import model.BinaryTree;

/**
 * @Author: zouhongxue
 * @Date: 2019/3/19 8:49 PM
 */
public class Traverse {

    public static void main(String[] args) throws Exception {
        int[] beforeArray = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] middleArray = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree tree = ConstructCore(beforeArray, 0, beforeArray.length - 1,
                middleArray, 0, middleArray.length - 1);
        System.out.println(tree);
    }

    private static BinaryTree ConstructCore(int[] preOrder, int startPreIndex, int endPreIndex,
                                            int[] inOrder, int startInIndex, int endInIndex) throws Exception {
        BinaryTree root = new BinaryTree();
        //构建根节点
        int rootValue = preOrder[startPreIndex];
        root.setValue(rootValue);

        //先序的头尾下标相同
        if (startPreIndex == endPreIndex) {
            //如果判断是否只有这一个元素，结束？
            if (startInIndex == endInIndex && preOrder[startPreIndex] == inOrder[startInIndex]) {
                System.out.println("only one element");
                return root;
            } else {
                throw new Exception();
            }
        }

        //求root在中序的位置
        int rootInIndex = startInIndex;
        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            rootInIndex++;
        }

        //这里断言 root在中序末尾的话 那么一定是rootValue 最后一个值。
        if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
            throw new Exception();
        }

        //划分中序左子树长度
        int leftLength = rootInIndex - startInIndex;
        //划分先序左子树结束位置
        int leftPreOrderEndIndex = startPreIndex + leftLength;
        if (leftLength > 0) {
            root.setLeftTree(ConstructCore(preOrder, startPreIndex + 1, leftPreOrderEndIndex,
                    inOrder, startInIndex, rootInIndex -1));
        }

        if (leftLength < endPreIndex - startPreIndex) {
            root.setRightTree(ConstructCore(preOrder, leftPreOrderEndIndex + 1, endPreIndex,
                    inOrder, rootInIndex + 1, endInIndex));
        }

        return root;
    }
}

package data.structure.list.linked;


/**
 * @ {leetCode 19题}
 * @Author: coffee
 */
public class ReverseDeleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode firstIndex = head;
            ListNode deletedNode = head;
            ListNode preNode = null;
            if (n < 1) {
                return head;
            } else {
                while (n > 1 && null != firstIndex.next) {
                    firstIndex = firstIndex.next;
                    n--;
                }
            }
            //如果删除节点是头节点
            if (n == 1 && null == firstIndex.next) {
                ListNode tmp = head.next;
                head.next = null;
                return tmp;
            } else {
                //三个指针顺序向后走, 一直到first到头
                while (null != firstIndex.next) {
                    firstIndex = firstIndex.next;
                    preNode = deletedNode;
                    deletedNode = deletedNode.next;
                }

                //说明是空链表或单节点链表
                if (null == preNode) {
                    return null;
                }

                //如果删除节点是尾节点
                if (null == deletedNode.next) {
                    preNode.next = null;
                } else {
                    preNode.next = deletedNode.next;
                    deletedNode.next = null;
                }

                return head;
            }
        }
    }

    public static void main(String[] args) {
        ReverseDeleteNode reverseDeleteNode = new ReverseDeleteNode();
        Solution solution = reverseDeleteNode.new Solution();
        ListNode nodeList = init();
        nodeList = solution.removeNthFromEnd(nodeList, 1);
        printNode(nodeList);
    }

    private static void printNode(ListNode nodeList) {
        while (null != nodeList) {
            System.out.println(nodeList.val);
            nodeList = nodeList.next;
        }
    }

    private static ListNode init() {
        ReverseDeleteNode reverseDeleteNode = new ReverseDeleteNode();
        ListNode listNode1 = reverseDeleteNode.new ListNode(1);
        ListNode listNode2 = reverseDeleteNode.new ListNode(2);
        ListNode listNode3 = reverseDeleteNode.new ListNode(3);
        ListNode listNode4 = reverseDeleteNode.new ListNode(4);
        ListNode listNode5 = reverseDeleteNode.new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }
}

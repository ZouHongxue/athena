package data.structure.list.linked;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @ {leetCode 21题}
 * @Author: coffee
 */
public class MergeSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 选择一个List作为结果返回,另一个插入
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;

        //判断空链表
        if (null == l1) {
            if (null != l2) {
                return l2;
            } else {
                return null;
            }
        } else if (null == l2) {
            return l1;
        }

        //初始化头节点
        if (l1.val >= l2.val) {
            result = l2;
            l2 = l2.next;
        } else {
            result = l1;
            l1 = l1.next;
        }
        ListNode index = result;
        //遍历两个链表
        while (null != l1 || null != l2) {
            if (null == l1) {
                index.next = l2;
                index = index.next;
                l2 = l2.next;
                continue;
            } else if (null == l2) {
                index.next = l1;
                index = index.next;
                l1 = l1.next;
                continue;
            }

            if (l1.val > l2.val) {
                index.next = l2;
                index = index.next;
                l2 = l2.next;
            } else {
                index.next = l1;
                index = index.next;
                l1 = l1.next;
            }
        }
        return result;
    }
}

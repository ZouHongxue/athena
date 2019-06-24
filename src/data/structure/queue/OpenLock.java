package data.structure.queue;

import java.util.*;

/**
 * @Author: coffee
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {
        //对每一位进行旋转，注意边界。过滤掉不合适的旋转。
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        HashSet<String> repeat = new HashSet<>(Arrays.asList(deadends));
        int res = 0;
        queue1.offer("0000");
        while (!queue1.isEmpty()) {
            String s = queue1.poll();
            if (target.equals(s)) {
                return res;
            }
            for(int i = 0; i < target.length(); i++) {
                click(queue2, s, i, repeat);
            }
            if(queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                res++;
            }
        }
        return -1;
    }

    void click(Queue<String> tmp, String str, int i, Set<String> deadends) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, sb.charAt(i) == '9' ? '0' : (char) (sb.charAt(i) + 1));
        if (!deadends.contains(sb.toString())) {
            tmp.offer(sb.toString());
        }
        sb = new StringBuilder(str);
        sb.setCharAt(i, sb.charAt(i) == '0' ? '9' : (char) (sb.charAt(i) - 1));
        if (!deadends.contains(sb.toString())) {
            tmp.offer(sb.toString());
        }
    }
}

package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouhongxue
 * @Date: 2019/4/24 7:00 PM
 */
public class Dfs {
    private static int ans = 0;
    private static List<Integer> ansList;
    private static List<List<Integer>> lists = new ArrayList<>();
    private static void dfs(int n, List<Integer> list) {
        if (n == 0) {
            int newAns = list.stream().reduce(1, (a, b) -> a * b);
            lists.add(new ArrayList<>(list));
            if (newAns > ans) {
                ansList = new ArrayList<>(list);
                ans = newAns;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
            dfs(n - i, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        dfs(2, new ArrayList<>());
        System.out.println(ansList);
        System.out.println(lists);
    }
}

package dp;

/**
 * 约瑟夫环
 *
 * @Author: zouhongxue
 * @Date: 2019/4/28 2:23 PM
 */
public class JosephLoop {

    public static void main(String[] args) {
        int n = 20;
        int m = 3;
        Integer[] loop = new Integer[n];
        initJosephLoop(loop);
        getWinner(loop, m);
        initJosephLoop(loop);
        getWinnerWithDp(loop, m);
    }

    private static void getWinnerWithDp(Integer[] loop, int m) {
        int winner = 0;
        for (int i = 1; i < loop.length; i++) {
            winner = (winner + m) % (i + 1);
        }
        System.out.println(winner);
    }

    private static void getWinner(Integer[] loop, int m) {
        int survivor = loop.length;
        int count = 1;
        while (survivor > 1) {
            for (int i = 0; i < loop.length; i++) {
                if (loop[i] >= 0) {
                    if (++count > m) {
                        loop[i] = -1;
                        survivor--;
                        count = 1;
                    }
                }
            }
        }

        for (Integer aLoop : loop) {
            if (aLoop > -1) {
                System.out.println(aLoop);
            }
        }
    }

    private static void initJosephLoop(Integer[] loop) {
        for (int i = 0; i < loop.length; i++) {
            loop[i] = i;
        }
    }
}

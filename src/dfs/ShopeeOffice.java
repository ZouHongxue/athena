package dfs;

import java.util.Scanner;

/**
 * 牛客网 Shopee的办公室
 * @Author: coffee
 */
public class ShopeeOffice {
    static int result = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        try {
            int x = Integer.valueOf(firstLine.split(" ")[0]);
            int y = Integer.valueOf(firstLine.split(" ")[1]);
            int n = Integer.valueOf(firstLine.split(" ")[2]);

            int[][] desk = new int[x + 1][y + 1];

            for (int i = 0; i < n; i++) {
                String tmp = in.nextLine();
                //置为Boss
                desk[y - Integer.parseInt(tmp.split(" ")[1])][Integer.parseInt(tmp.split(" ")[0])] = 1;
            }
            findWay(desk, x, 0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("must be out of index");
            e.printStackTrace();
        }

    }

    private static void printCheck(int[][] desk) {
        for (int[] aDesk : desk) {
            for (int anADesk : aDesk) {
                System.out.print(anADesk + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    private static void findWay(int[][] desk, int x, int y) {
        if (x == 0 && y == desk[0].length - 1) {
//            System.out.println("Success");
            result++;
        }

        //遇到Boss回头
        if (desk[x][y] == 1) {
            return ;
        }

//        desk[x][y] = -1;
//        printCheck(desk);
//        desk[x][y] = 0;

        //向上
        if (x != 0) {
            findWay(desk, x - 1, y);
        }
        //向右
        if (y != desk.length - 1) {
            findWay(desk, x, y + 1);
        }
    }
}

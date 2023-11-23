import java.util.*;
class Solution {
    static int[] sales = {10, 20, 30, 40};
    static int[] total;
    static Queue<int[]> queue;

    public int[] solution(int[][] users, int[] emoticons) {

        total = new int[emoticons.length];
        queue=new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        dfs(0, users, emoticons);
        return queue.peek();
    }

    private void dfs(int depth, int[][] users, int[] emoticons) {

        if (depth == total.length) {

            int join = 0;
            int money = 0;

            for (int[] user : users) {
                int discount = user[0];
                int max_money = user[1];

                int total_money = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (total[j] >= discount) {
                        total_money += emoticons[j] * (100 - total[j]) / 100;
                    }
                }
                if (total_money >= max_money) {
                    join += 1;
                } else {
                    money += total_money;
                }
            }
            queue.offer(new int[]{join, money});
            return;
        }

        for (int i = 0; i < sales.length; i++) {
            total[depth] = sales[i];
            dfs(depth + 1, users, emoticons);
        }
    }
}

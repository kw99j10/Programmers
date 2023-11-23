import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (k == enemy.length) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {

            //병사가 부족하고 무적권이 없다면 공격을 막을 수 없으므로 반복문 종료
            if (n < enemy[i] && k == 0) {
                break;
            }

            queue.offer(enemy[i]);

            //현재 적보다 병사 수가 부족하면
            //최소로 병사 수를 소비한 라운드를 다시 병사 수에 더한 후 무적권 사용
            if (!queue.isEmpty() && enemy[i] > n) {
                n += queue.poll();
                k -= 1;
            }

            n -= enemy[i];
            answer += 1; //막을 수 있는 라운드는 계속 증가
        }
        return answer;

    }
}

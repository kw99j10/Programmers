import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        //상자 개수 & 거리를 담을 리스트
        var d = new LinkedList<int[]>(); //배달할 상자 & 거리
        var p = new LinkedList<int[]>(); //수거할 상자 & 거리

        //상자가 있다면 list에 저장
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                d.add(new int[]{deliveries[i], i + 1});
            }
            if (pickups[i] != 0) {
                p.add(new int[]{pickups[i], i + 1});
            }
        }

        int sum; //택배 상자의 합
        int dist; //이동 거리

        // 배달 or 수거 상자 모두 없으면 반복문 종료
        while (!d.isEmpty() || !p.isEmpty()) {

            sum = 0;
            dist = 0;

            while (!d.isEmpty()) {
            
                if (sum >= cap) {
                    break; //택배 합이 트럭에 실을 수 있는 최대 상자 개수보다 크거나 같아지면 종료
                }
                
                int[] poll = d.pollLast(); //거리가 가장 먼 집

                dist = Math.max(dist, poll[1]);

                if (cap >= poll[0] + sum) {
                    sum += poll[0]; //최대 허용 상자 개수 > 택배 수 -> 합을 누적
                }
                else{
                    poll[0] -= (cap - sum);
                    d.add(poll); //최대 개수를 빼고 나머지 택배 상자를 다시 list에 저장
                    break; //허용 상자 개수를 넘으면 더이상 배달을 진행할 수 없으므로 반복문 종료
                }
            }
            sum = 0; //누적 합 초기화: 배달 -> 수거

            while (!p.isEmpty()) {
                
                if (sum >= cap) {
                    break;
                }
                
                int[] poll = p.pollLast();

                dist = Math.max(dist, poll[1]);

                if (cap >= poll[0] + sum) {
                    sum += poll[0];
                }
                else{
                    poll[0] -= (cap - sum);
                    p.add(poll);
                    break;
                }
            }
            answer += dist * 2L;
        }

        //배달 -> 수거 순
        return answer;
    }
}

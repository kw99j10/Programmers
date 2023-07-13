import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        var ready=new LinkedList<Integer>(); //다리를 지난 트럭을 담을 큐

        for (int i = 0; i < bridge_length; i++) {
            ready.offer(0);
        }

        int sum = 0;

        int i = 0;
        while (true) {

            //cf) 트럭은 1초에 길이 1만큼 다리를 건넘
            if (i >= truck_weights.length) {
                answer += bridge_length; //배열의 끝에 도달 했으면 다리의 길이만큼 초를 더한 후 종료
                break;
            }

            answer += 1;
            sum -= ready.poll(); //도착한 트럭 큐의 첫번째 요소를 제거

            if (weight >= truck_weights[i] + sum) {
                ready.offer(truck_weights[i]);
                sum += truck_weights[i];
                i += 1; //weight보다 작거나 같을 경우만 배열 index를 증가
            }
            else{
                ready.offer(0); //weight 초과시 큐에 0을 넣음
            }
        }
    
        return answer;
    }
}

<큐 2개 사용 풀이>
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        var finish=new LinkedList<Integer>(); //도착한 트럭을 담을 큐
        var ready=new LinkedList<Integer>(); //다리를 건널 트럭을 담은 큐
        
        for (int truck_weight : truck_weights) {
            ready.add(truck_weight);
        }

        for (int i=0;i<bridge_length;i++){
            finish.add(0); //도착할 큐에 다리 길이 만큼 0으로 채워 넣음
        }

        int sum=0; //다리 위 트럭의 총합을 나타낼 변수

        while (true){

            sum-=finish.peek();
            finish.poll(); //도착한 트럭 큐의 첫번째 요소를 제거

            if (ready.isEmpty()){
                answer+=bridge_length; //마지막 요소이면 다리의 길이만큼 초를 더한 후 종료
                break;
            }
            else{
                if (weight>=sum+ready.peek()){
                    finish.add(ready.peek());
                    sum+=ready.peek(); //아니라면 다리의 무게만큼 요소를 더해나감
                    ready.poll();
                }
                else{
                    finish.add(0); //무게보다 클 경우 finish 큐 마지막에 0을 넣음
                }
            }
            answer+=1;
        }
        
    
        return answer;
    }
}

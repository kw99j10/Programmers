import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
         //프로세스 당 우선순위를 두므로 우선순위 큐를 생성
        var q = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //우선순위가 높은(숫자가 큰)순서대로 큐에 들어감
        for(int i=0;i<priorities.length;i++){
            q.add(priorities[i]);
        }
        boolean k=false;
        
        while(!q.isEmpty()){
            
            if(k){
                break;
            }
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==q.peek()){
                    if(i==location){
                        k=true;
                        break; //i와 location이 같다면 종료, 해당 순서에 실행
                    }
                    q.poll(); //i와 location이 같지 않을 수도 있음 ex)-([1,1,9,1,1,1])
                    answer+=1;
                }
                System.out.println(priorities[i]+" "+q.peek());
            }
        }       
        return answer;
    }
}


//이전 코드
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<int []> q= new LinkedList<>();

        for(int i=0;i<priorities.length;i++){
            int process=priorities[i];
            q.add(new int[]{process,i});
        }
        int count = 0;
        while (!q.isEmpty()) {

            int[] ans = q.poll();
            boolean b = true;
            for (int i = 0; i < q.size(); i++) {
                if (q.get(i)[0] > ans[0]) {
                    q.add(ans);

                    for (int j = 0; j < i; j++) {
                        q.add(q.poll());
                    }
                    b = false;
                    break;
                }
            }
            if (!b) {
                continue;
            }
            else{
                count+=1;
            }
            if(ans[1]==location){
                break;
            }
        }
        answer = count;
        
        return answer;
    }
}

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        var answer=new ArrayList<Integer>();
        var s=new LinkedList<Integer>();
      
        //프로세스를 처리하는데 걸리는 기간을 계산하여 list(queue)에 담음
        for(int i=0;i<progresses.length;i++){
            int progress=progresses[i];
            
            int day=0;
            
            while(true){
                if(progress>=100){
                    break;
                }
                progress+=speeds[i];
                day+=1;
            }
            s.add(day);
        }
        
        int tmp=0; //기간 비교위한 변수
        int count=0; //배포하는 기능 수

        //맨 앞의 값을 그 다음값과 비교 ==> 앞>=뒤: 제거// 뒤>앞: 뒤까지 같이 제거
        while(!s.isEmpty()){
            if(tmp>=s.peek()){
                s.poll();
            }
            else{
                tmp=s.poll();
            }
            count+=1; 
            System.out.println(tmp+" "+s.peek()+" "+count); //순서 확인
            
            if(s.isEmpty()){ 
                answer.add(count); //마지막 값이면 여태까지의 count를 list에 더함
            }
            else if(s.peek()>tmp){ 
                answer.add(count); //뒷일이 앞일보다 늦게 끝나는 경우 list에 count를 더함
                count=0;
                tmp=0;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

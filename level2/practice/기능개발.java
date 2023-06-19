import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        var a=new LinkedList<Integer>();     
        var day=new ArrayList<Integer>();
        
        int count=0; //한 번에 배포되는 기능 수
        for(int i=0;i<progresses.length;i++){
            double remain=(double)(100 - progresses[i]) / speeds[i]; //나머지 연산을 통해 남은 일 수를 계산
            int date=(int)Math.ceil(remain); //나머지가 있으면 올림 처리
            
            if(!a.isEmpty() && a.peek()<date){
                day.add(count);
                a.clear();
                count=0;
            }
            a.add(date);
            count+=1;
        }
        day.add(a.size()); //마지막 연산이 포함되지 않으므로 남아있는 일 수만큼 list에 더함
        int []answer=new int[day.size()]; // list->array
        for(int i=0;i<answer.length;i++){
            answer[i]=day.get(i);
        }
        
        return answer;
    }
}

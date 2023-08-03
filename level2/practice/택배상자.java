import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        var s=new Stack<Integer>(); //보조 컨테이너
        
        int count=0; //order 배열 순서 변수
        // 택배상자는 크기가 모두 같으며 1번 상자부터 n번 상자까지 번호가 증가하는 순서대로 컨테이너 벨트에 일렬로 놓여 있음
        for(int i=1;i<=order.length;i++){
            
            // 1.보조 컨테이너에서 상자 순서가 일치할 경우
            while(true){
                if(!s.isEmpty() && s.peek()==order[count]){
                    s.pop();
                    count+=1;
                    answer+=1;
                }
                else{
                    break;
                }
            }
            // 2.원하는 상자 순서일 경우
            if(order[count]==i){
                count+=1;
                answer+=1;
            }
            // 3.원하지 않는 상자 순서일 경우
            else{
                s.push(i);
            }
        }
        // 4.stack에 남은 요소가 존재할 경우
        while(!s.isEmpty()){
            if(order[count]==s.peek()){
                answer+=1; //순서가 일치하면 계속 pop
                s.pop();
            }
            else{
                break; //순서 불일치시 반복문 종료
            }
            count+=1;
        }
        return answer;
    }
}

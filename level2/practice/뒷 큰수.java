import java.util.*;
//뒷 큰수: 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1); //뒷 큰수가 존재하지 않는 경우: -1
        
        var s=new Stack<Integer>();

        //stack에 "index"를 push하여 stack 제일 위에있는 number index와 현재 number index의 값을 비교
        //값에 따른 반복문 여부 결정
        for(int i=0;i<numbers.length;i++){
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                answer[s.pop()] = numbers[i];
            }
            s.push(i);
        }
    
        return answer;
    }
}

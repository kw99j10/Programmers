import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        var a=new ArrayList<Integer>();
        a.add(numbers[0]);
        a.add(numbers[0]*(-1)); //배열의 시작 값을 '+', '-' 로 저장

        for(int i=1;i<numbers.length;i++){
            int tmp=numbers[i];

            var t = new ArrayList<Integer>(); //메모리 초과 방지

            for (Integer integer : a) {
                t.add(integer + tmp);
                t.add(integer - tmp);
            }
            a = t;
        }
        for (Integer integer : a) {
            if(integer==target){
                answer+=1;
            }
        }
        return answer;
    }
}

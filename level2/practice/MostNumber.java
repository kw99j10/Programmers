import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
      //정수형 배열 -> 문자열 배열 변형(정답 범위가 int 범위를 넘을 수 있으므로)
        String []k=new String[numbers.length];
        for(int i=0;i<k.length;i++){
            k[i]=String.valueOf(numbers[i]);
        }
      
      //문자열의 합에 따른 배열 정렬
       Arrays.sort(k, (o1, o2) -> {

            if (o1.length() == o2.length()) {
                int a = Integer.parseInt(o1);
                int b = Integer.parseInt(o2);
                return Integer.compare(a, b);
            }
            else {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int i = k.length - 1; i >= 0; i--) {
            answer += k[i];
        }
      
      //단 0으로만 이루어진 배열이라면 0으로 출력
         if (answer.startsWith("0")) {
            answer = "0";
        }
        return answer;
    }
}

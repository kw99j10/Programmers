import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        
        long fct = 1; //팩토리얼 계산을 위한 변수
        int count = 0; //사람 수 count 변수

        var a = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            a.add(i); //총 줄서는 인원
            fct *= i;
        }

        k -= 1; //index는 0부터 시작이므로 -1
        int[] answer = new int[n];

        //n이 3일 때 경우의 수 -> (1,2,3),(1,3,2),(2,1,3),(2,3,1),(3,1,2),(3,2,1) : 2번마다 앞자리가 바뀜 ==> fact(n)/2: 6/2=3(==n)
        //n이 4일 때 경우의 수 -> 6번마다 앞자리가 바뀜 ==> fact(4)/6: 24/6=4(==n)
        while (n != 0) {

            fct /= n; //n이 0이 될 때까지 배열에 팩토리얼의 자릿 수를 대입
            answer[count] = a.remove((int) (k / fct));
            k %= fct;
            count += 1;
            n -= 1;
        }
        return answer;
    }
}

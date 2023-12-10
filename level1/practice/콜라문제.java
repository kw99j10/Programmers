package org.example.kw99j10.programmers.lv1;
public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        //빈병이 주어야 하는 병의 개수보다 적으면 교환할 수 없음
        while (n >= a) {
            answer += (n / a) * b; //병을 교환
            n = (n / a) * b + n % a; //병 개수 누적
        }
        return answer;
    }
}

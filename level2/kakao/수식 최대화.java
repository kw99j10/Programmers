import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;

        var num = new ArrayList<Long>(); //문자열 중 피연산자를 담을 리스트
        var op = new ArrayList<Character>(); //문자열 중 연산자를 담을 리스트

        String p = "";
        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                op.add(c);
                num.add(Long.valueOf(p));
                p = "";
            }
            else{
                p += c;
            }
        }
        num.add(Long.valueOf(p));

        String[] opt = {"*+-", "*-+", "+-*", "+*-", "-*+", "-+*"}; //연산자 우선순위 총 경우의 수

        for (String s : opt) {
            var tmpNum = new ArrayList<>(num);
            var tmpOpt = new ArrayList<>(op);

            //주어진 연산자의 총 경우의 수에 따라 우선순위대로 계산하여 가장 큰 절댓값을 구함
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < tmpOpt.size();) {
                    if (s.charAt(i) != tmpOpt.get(j)) {
                        j += 1;
                        continue;
                    }
                    if (tmpOpt.get(j) == '*') {
                        tmpNum.set(j,tmpNum.get(j) * tmpNum.get(j + 1));
                    }
                    else if (tmpOpt.get(j) == '+') {
                        tmpNum.set(j, tmpNum.get(j) + tmpNum.get(j + 1));
                    }
                    else if (tmpOpt.get(j) == '-') {
                        tmpNum.set(j, tmpNum.get(j) - tmpNum.get(j + 1));
                    }
                    tmpNum.remove(j + 1); //계산 후 뒤 피연산자 제거
                    tmpOpt.remove(j); //계산에 사용한 연산자 제거
                }
                //제거 후 우선순위대로 다시 연산 반복 수행
            }
            answer = Math.max(answer, Math.abs(tmpNum.get(0)));
        }
        
        return answer;
    }
}

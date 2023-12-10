package org.example.kw99j10.programmers.lv1;
public class 푸드파이트대회 {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        //물 제외한 음식 종류 별 개수 list에 추가
        for (int i = 1; i < food.length; i++) {
            if (food[i] == 1) {
                continue;
            }
            int tmp = food[i] / 2;
            answer.append(String.valueOf(i).repeat(Math.max(0, tmp)));
        }
        String t = answer.toString();
        return t + "0" + answer.reverse();
    }
}

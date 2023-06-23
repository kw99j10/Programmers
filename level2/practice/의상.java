import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        var h = new HashMap<String, Integer>(); //key: 의상 종류, value: 의상 이름
        for (int i = 0; i < clothes.length; i++) {
            if (!h.containsKey(clothes[i][1])) {
                h.put(clothes[i][1], 1); //다른 종류의 의상이 들어오면 put
            }
            else{
                h.put(clothes[i][1], h.get(clothes[i][1]) + 1; // 같다면 누적
            }
        }
        int count = 1; //경우의 수를 구하기 위해 변수를 1로 설

        for (Integer value : h.values()) {
            count *= (value + 1); //value에 1을 더함: 안 입는 경우를 셈
        }
        answer = count - 1; //아무것도 입지 않은 경우의 수 1을 뺌
        return answer;
    }
}

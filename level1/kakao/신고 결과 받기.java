import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        var h1=new HashMap<String,Integer>(); //신고 횟수
        var h2=new HashMap<String, HashSet<String>> (); //신고 관계
        for (String s : id_list) {
            h1.put(s, h1.getOrDefault(s, 0));
            h2.put(s, new HashSet<>());
        }

        //(set 사용: 동일한 유저에 대한 신고 횟수는 1회처리)
        for (String value : report) {
            String[] tmp = value.split(" ");
            String reporter = tmp[0]; //신고한 사람
            String object = tmp[1]; //신고당한 대상

            h2.get(object).add(reporter); //(신고당한 사람, 신고한 사람)
        }

        //set에 들어 있는 수만큼 h1에 put
        for (String s : h2.keySet()) {
            HashSet<String> count = h2.get(s);
            if (h2.get(s).size() >= k) {
                for (String s1 : count) {
                    h1.put(s1, h1.get(s1) + 1);
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = h1.get(id_list[i]); //출력하는 answer(신고 한 횟수)의 순서는 id_list와 같음
        }
        return answer;
    }
}

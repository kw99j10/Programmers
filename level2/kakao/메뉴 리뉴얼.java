import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
class Solution {
    static HashMap<String, Integer> map; //메뉴 조합, 조합이 나온 횟수

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>(); //결과(코스요리 메뉴 구성)를 담을 리스트

        for (int i = 0; i < orders.length; i++) {
            char[] array = orders[i].toCharArray();
            Arrays.sort(array);
            orders[i] = String.valueOf(array); //메뉴 중복 방지
        }
        
        for (int length : course) {
            for (String order : orders) {
                comb("", order, length); //나올 수 있는 메뉴 조합을 생성
            }
            if (!map.isEmpty()) {
                ArrayList<Integer> lists = new ArrayList<>(map.values());
                lists.sort(((o1, o2) -> o2 - o1)); //횟수별 내림차순 정렬
                int max = lists.get(0);

                //주문 횟수가 최소 손님 2명이상인 경우에만
                if (max > 1) {
                    for (String s : map.keySet()) {
                        if (map.get(s).equals(max)) {
                            result.add(s);
                        }
                    }
                }
            }
            map.clear(); //다음 코스요리 길이에 대하여 조합 실행을 위해 map을 비움
        }
        Collections.sort(result); //리스트 사전 순 정렬
        return result.toArray(new String[0]);
    }

    private void comb(String s, String order, int length) {
        if (length == 0) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return; //map에 부분 문자열 누적
        }
        for (int i = 0; i < order.length(); i++) {
            comb(s + order.charAt(i), order.substring(i + 1), length - 1);
        }
    }
}

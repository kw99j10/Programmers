import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
class Solution {
    static HashMap<String, List<Integer>> map; //가능한 쿼리 조건과 코테 점수(리스트 사용: 조건마다 다른 점수를 가질 수 있음)

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String s : info) {
            String[] tmp = s.split(" ");
            dfs(tmp, "", 0);
            //"-"를 포함하여 가능한 모든 경우의 수
        }

        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", ""); //and 문자열 공백문자 대체
            String[] words = query[i].split(" ");//공백 단위로 쿼리 분할

            //탐색을 통해 만든 문자열이 query에 있다면 이분탐색 수행
            answer[i] = map.containsKey(words[0]) ? binarySearch(words[0], Integer.parseInt(words[1])) : 0;
        }
        return answer;
    }

    //점수에 따른 이분탐색
    private int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (score > list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start; //start 이하 값은 점수를 만족하지 않으므로 이를 뺀 것이 기준을 만족하는 요소 개수
    }

    //나올 수 있는 모든 경우의 수를 완전 탐색
    private void dfs(String[] tmp, String words, int count) {
        if (count == 4) { //평가 요소가 총 4개이므로
            if (!map.containsKey(words)) {
                ArrayList<Integer> lists = new ArrayList<>();
                map.put(words, lists);
            }
            map.get(words).add(Integer.parseInt(tmp[4]));
            return;
        }
        dfs(tmp, words + "-", count + 1); //"-"가 있는 경우
        dfs(tmp, words + tmp[count], count + 1); //"-"가 없는 경우
    }
}

import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length]; //cf) targets의 길이와 같아야 함, keymap.length!=targets.length
        
        var c = new HashMap<Character, Integer>();
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                c.put(c1, Math.min(i + 1, c.getOrDefault(c1, i + 1)));
                //최소 키 누름 횟수를 구하는 문제이므로 keymap들 중에서 해당 문자의 최소(인덱스) 위치를 map에 넣는다.
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                char c1 = targets[i].charAt(j);

                if (c.containsKey(c1)) {
                    answer[i] += c.get(c1);
                }
                else{
                    answer[i] = -1; //존재하지 않으므로 반복문을 빠져나옴
                    break;
                }
            }
        }
        return answer;
    }
}

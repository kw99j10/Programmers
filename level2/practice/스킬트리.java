import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        var h = new HashSet<Character>();
        var a = new ArrayList<String>();

        for (int i = 0; i < skill.length(); i++) {
            String k = skill.substring(0, i + 1); //순서에 맞는 스킬트리의 부분집합을 리스트에 넣음
            h.add(skill.charAt(i)); //스킬 트리를 이루는 요소들을 set에 넣음
            a.add(k);
        }

        for(int i=0;i<skill_trees.length;i++){

            String ans=skill_trees[i];
            String t = "";  //리스트에 있는 스킬 트리인지 판단하기 위한 문자열

            int[] num = new int[26]; //알파벳 중복 방지 배열
            boolean k = true;

            for(int j=0;j<ans.length();j++){
                char c = ans.charAt(j);

                if (!k) {
                    break;
                }
                for (int value : num) {
                    if (value > 1) {
                        k = false; //value가 1보다 크면 해당 문자는 2번 이상 나온 것이므로 반복문을 종료
                        break;
                    }
                }
                num[c - 65] += 1; //알파벳에 해당하는 index+1

                if (h.contains(c)) {
                    t += c; //스킬트리를 이루는 요소이면 문자열을 만듦.
                }
            }
            if (t.equals("")) {
                if (!skill.contains(ans) || !ans.contains(skill)) {
                    answer += 1;  //만약 빈 문자열이라면 해당 문자열은 스킬 트리를 이루는 요소들로 이루어진 문자열이 아니므로 순서에 상관없이 배울 수 있음(+1 가능)
                }
            }
            if (k) {
                for (String s : a) {
                    if (t.equals(s)) {
                        answer += 1; //스킬 트리를 이루는 요소들로 이루어진 문자열이 순서에 맞는 지 판단
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

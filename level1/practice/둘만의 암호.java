import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        //알파벳 포함 여부 확인 위한 boolean형 배열
        boolean[] b = new boolean[26];
        Arrays.fill(b, true);

        //포함시 false(count하지 않기 위함)
        for (int i = 0; i < skip.length(); i++) {
            char c = skip.charAt(i);
            b[c - 97] = false;
        }
      
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            int count = 0;
            while (true) {

                //'z'를 넘어가면 'a'부터 다시 시작
                if (c >= 122) {
                    c -= 26;
                }
                //true시 count(미 포함 문자이므로)
                if (b[c - 96]) {
                    count += 1;
                }
                c += 1;

                //cf)조건문 순서 중요==> 우선 알파벳을 count한 후 index와 비교 후 문자 저장
                if (count == index) {
                    answer += (char) c;
                    break;
                }
            }
        }
        return answer;
    }
}

//성능 최적화(StringBuilder)
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char alpha : s.toCharArray()) {
            char temp = alpha;
            int count = 0;
            while (count < index) {
                //'z'일 경우만 'a'로 넘겨서 시작(예외처리)
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    count += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }
}

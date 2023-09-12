import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        var a = new ArrayList<>(Arrays.asList(words));
        Collections.sort(a); // begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾기 위해 리스트 정렬

        int i = 0;
        while(!begin.equals(target)) {

            if (i >= a.size() - 1) {
                answer = 0; 
                break; //target이 없거나 target에 도달할 수 없는 경우 종료
            }

            int count = 0;

            String tmp = a.get(i);

            for (int j = 0; j < tmp.length(); j++) {

                char c1 = begin.charAt(j);
                char c2 = tmp.charAt(j);

                if (c1 == c2) {
                    count += 1; //일치하는 알파벳 개수 비교
                }
            }
            if (begin.length() - count == 0) {
                break; //target과 일치할 경우
            }
            else if (begin.length() - count == 1) {
                begin = tmp;
                a.remove(a.get(i)); //한 번에 한개의 알파벳 변경하여 target에 도달
                answer += 1;
                i = 0;
            }
            else {
                i += 1; //한 번에 한개의 알파벳만 바꿀 수 없으면 다음 index로 이동
            }
        }

        return answer;
    }
}

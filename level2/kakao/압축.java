import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        var a = new ArrayList<Integer>(); //사전번호를 담을 list
        var h = new HashMap<String, Integer>();

        for (int i = 0; i < 26; i++) {
            h.put(String.valueOf((char) ('A' + i)), (i + 1)); //'A'~'Z' 까지 사전 초기화
        }
        for (int i = 0; i < msg.length(); i++) {
            String tmp = String.valueOf(msg.charAt(i));

            if (i == msg.length() - 1) {
                a.add(h.get(tmp)); //문자열의 끝일 경우 해당 사전번호를 등록하고 종료
                break;
            }
            String next = String.valueOf(msg.charAt(i + 1));

            while (h.containsKey(tmp + next)) { //3글자 이상 단어 사전에 담기위한 반복문

                tmp += next;
                i += 1;
                if (i == msg.length() - 1) {
                    break;
                }
                next = String.valueOf(msg.charAt(i + 1));
            }
            if (!h.containsKey(tmp + next)) {
                h.put(tmp + next, h.size() + 1); //사전에 없다면 새로 담음
            }
            a.add(h.get(tmp)); //해당하는 사전번호를 담음
        }
        int []answer=new int[a.size()];
        for(int i=0;i<a.size();i++){
            answer[i]=a.get(i);
        }
        return answer;
    }
}

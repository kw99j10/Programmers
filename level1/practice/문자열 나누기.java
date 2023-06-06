import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //같은 문자 count
        int count1=1;
        //다른 문자 count
        int count2=0;
        var a = new ArrayList<String>();
      
        //리스트에 담을 문자열 묶음
        String t = String.valueOf(s.charAt(0));
      
        //문자가 다른지 같은지 체크하기 위한 변수
        char c=s.charAt(0);
      
        //문자열의 길이가 1이면 해당 문자열만 리턴
        if (s.length() == 1) {
            a.add(s);
        }
        for(int i=1;i<s.length();i++){

            //count가 같으면 리스트에 그동안 더한 t를 저장, count 초기화, t(문자묶음) 초기화
            if (count1 == count2) {

                a.add(t);
                count1 = 1;
                count2 = 0;
                t = "";
                c = s.charAt(i);
            }

            //t를 초기화한 상태는 count1이 1인 상태이므로 count1을 더하지 않음
            if (!t.equals("")) {
                if (s.charAt(i) == c) {
                    count1 += 1;
                }
                else{
                    count2 += 1;
                }
            }
            t += s.charAt(i);

            //마지막 묶음은 리스트에 따로 저장
            if (i == s.length() - 1) {
                a.add(t);
            }
        }
        answer = a.size();
        return answer;
    }
}

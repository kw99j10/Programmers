import java.util.*;
class Solution {
    public int solution(String s) {
      
        int count = 0; //올바른 괄호 문자열 count 변수
        String q = ""; //뒤에 연결할 배열
        for (int i = 0; i < s.length(); i++) {

            boolean k = true; //올바른 괄호 문자열 판단 변수
            var st = new Stack<Character>();

            String t = s.substring(i).concat(q);
            q += s.charAt(i);

            for (int j = 0; j < s.length(); j++) {

                char c = t.charAt(j);

                //여는 문자가 올 경우 push
                if (c == '{' || c == '(' || c == '[') {
                    st.push(c);
                }
                //닫는 문자는 종류가 3개이므로 경우에 따라 나눔
                else if (c == ')') {
                    if (st.isEmpty() || !(st.peek() == '(')) {
                        st.push(c);
                        k = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
                else if (c == '}') {
                    if (st.isEmpty() || !(st.peek() == '{')) {
                        st.push(c);
                        k = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
                else if (c == ']') {
                    if (st.isEmpty() || !(st.peek() == '[')) {
                        st.push(c);
                        k = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if (!st.isEmpty()) {
                k = false;
            }
            if (k){
                count += 1;
            }
        }
        return count;
    }
}

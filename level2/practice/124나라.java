#stack
import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";

        var s=new Stack<Integer>();

        while(n>3){

            if(n%3==0){
                s.push(3);
                n=n/3-1;
            }
            else{
                s.push(n%3);
                n=n/3;
            }
        }
        s.push(n);

        while(!s.isEmpty()){
            if(s.peek()==3){
                answer+="4";
                s.pop();
            }
            else{
                answer+=String.valueOf(s.pop());
            }
        }
        return answer;
    }
}

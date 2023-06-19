# index 풀이 4,12 시간초과
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb=new StringBuilder();
        for (int i : ingredient) {
            sb.append(i);
        }
        String k=sb.toString();
        while (k.contains("1231")){
            answer+=1;
            int index=k.indexOf("1231");
            k=k.substring(0,index)+k.substring(index+4);
        }
        return answer;
    }
}

#stack 풀이 -->push 후 들어있는 숫자가 1,2,3,1 순서인지 확인
import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        var s=new Stack<Integer>();
        
        for (int i : ingredient) {
            s.push(i);
            
            if(s.size()>=4){
                if(s.get(s.size()-4)==1 && s.get(s.size()-3)==2 && s.get(s.size()-2)==3 && s.get(s.size()-1)==1){
                    answer+=1;
                    s.pop();
                    s.pop();
                    s.pop();
                    s.pop();
                }
            }
        }
        return answer;
    }
}

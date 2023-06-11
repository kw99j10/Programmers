import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //people 배열 요소를 담음
        var a=new ArrayList<Integer>();
        for(int i:people){
            a.add(i);
        }
        
        //리스트에서 내림차순으로 계산하기 위함-> linkedlist에 push 시 해당 요소 앞에 값이 들어감
        Collections.sort(a);
        
        var s=new LinkedList<Integer>();
        
        for(int i=0;i<a.size();i++){
            s.push(a.get(i));
        }
        
        while (!s.isEmpty()) {

            //리스트의 사이즈가 1이면 남은 사람이 1명이라는 1명만 구명보트에 태움
            if (s.size() == 1) {
                s.removeLast();
                answer+=1;
            }
          
            //리스트의 사이즈가 2 이상일 시 조건에 따라 사람을 구명보트에 태움
            for (int i = 0; i < s.size(); i++) {
                int b = s.peekFirst(); //list의 첫요소
                int c = s.peekLast(); //list의 끝요소
                if (b + c <= limit) {
                    s.removeFirst();
                    s.removeLast();
                    answer += 1;
                } 
                else {
                    s.removeFirst();
                    answer += 1;
                }
            }
        }
        return answer;
    }
}

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";

        var s=new Stack<Character>();
        int p=k; //k가 1일 경우와 아닐 경우를 나누어서 조건문을 수행

        //k가 1일 경우 조건문을 수행하지 않을 수 있음 (반례:4321) 이와 같은 경우는 최소값 index 하나만을 삭제
        if (p==1){
            int min=9;

            for (int i=0;i<number.length();i++){
                min=Math.min(min,Integer.parseInt(String.valueOf(number.charAt(i))));
            }
            for (int i=0;i<number.length();i++){
                int tmp=Integer.parseInt(String.valueOf(number.charAt(i)));
                if (min!=tmp){
                    s.push(number.charAt(i));
                }
            }
            for (Character character : s) {
                answer+=character;
            }
        }

        else{
            for (int i=0;i<number.length();i++) {
                char c = number.charAt(i);
                while (true){

                    if (s.isEmpty() || k==0 || s.peek()>=c){
                        break; //스택이 비어있거나 k가 0이거나(모두 삭제했거나) 스택의 peek 값이 현재 값보다 크거나 같으면 while문을 수행하지 않음
                    }
                    s.pop(); //위 if문을 만족하지 않다면 peek 값을 pop(삭제: k-=1)
                    k-=1;
                }
                s.push(c); //for문에서는 주어진 값을 push 함
            }
            for (Character character : s) {
                answer+=character;
            }
        }
        return answer;
    }
}

//첫 풀이 -> 모든 문자를 리스트에 대입 후 연산
import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        String t = ""; //1단계 대문자->소문자

        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (c!='-' && c!='_' && c!='.' && !(c>='a' && c<='z') && !(c>='0' && c<='9')){
                c = ' ';
            }
            t += c;
        }
        t = t.replace(" ", "");
        //2단계 소문자, 숫자, 그외 특수문자 제외 모든 문자 제거

        var a=new LinkedList<Character>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);

            if(a.isEmpty()){
                a.add(c);
            }
            else{
                if(a.peekLast()=='.' && c=='.'){
                    continue;
                }
                a.add(c);
            }
        }
        //3단계 마침표 2번 이상 연속 부분 -> 하나의 마침표로 치환


        if (a.size() > 1) {
            for (int i = 0; i < a.size(); i++) {
                if (a.getFirst() == '.') {
                    a.pollFirst();
                }
                if (a.getLast() == '.') {
                    a.pollLast();
                }
            }
        }
        else{
            if (a.get(0) == '.') {
                a.removeFirst();
            }
        }
        //4단계 처음과 끝에 있는 마침표 제거

        if(a.isEmpty()){
            a.add('a');
        }
        //5단계 t(new_id) 빈 문자열 일 시 "a" 대입

        if(a.size()>=16){
            while(!(a.size()==15)){
                a.remove(a.size()-1);
            }
        }

        for(int i=0;i<a.size();i++){
            if (a.getLast() == '.') {
                a.pollLast();
            }
        }
        //6단계 문자열 길이 15 제한 && 끝 문자열 '.' 확인

        if(a.size()<=2){
            char q=a.get(a.size()-1);

            while(!(a.size()==3)){
                a.add(q);
            }
        }
        //7단계 문자열 최소 길이 설정하기 위해 마지막 문자 더함

        answer="";
        for(int i=0;i<a.size();i++){
            answer+=a.get(i);
        }
        return answer;
    }
}

//정규표현식 사용
import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String t = new_id.toLowerCase(); //1단계 대문자->소문자
        t=t.replaceAll("[^-_.a-z0-9]",""); //2단계 소문자, 숫자, 그외 특수문자 제외 모든 문자 제거
        t = t.replaceAll("[.]{2,}","."); //3단계 2번이상 반복되는 '.' 제거
        t = t.replaceAll("^[.]|[.]$",""); //4단계 마침표가 처음이나 끝에 위치하면 제거
        
        if(t.equals(""))
            t+="a"; //5단계 빈 문자열이면 "a" 대입
        
        if(t.length() >=16){
            t = t.substring(0,15);
            t=t.replaceAll("^[.]|[.]$","");
        } //6단계 길이 15제한 및 끝에 '.'가 올 경우 제거
        
        if(t.length()<=2)
            while(t.length()<3)
                t+=t.charAt(t.length()-1); //7단계 최소 길이 3 설정

        answer=t;
        return answer;
    }
}

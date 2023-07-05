import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        var a = new ArrayList<String>();
        var b = new ArrayList<String>();

        //두 문자열을 각각 두글자씩 끊어서 각 리스트에 저장 (alphabet만)
        for (int i = 0; i < str1.length()-1; i++) {
            char c=str1.charAt(i);
            char d=str1.charAt(i+1);

            if ((c>='a' && c<='z') && (d>='a' && d<='z')){
                a.add(String.valueOf(c)+d);
            }
        }
        for (int i = 0; i < str2.length()-1; i++) {
            char c=str2.charAt(i);
            char d=str2.charAt(i+1);

            if ((c>='a' && c<='z')  && (d>='a' && d<='z')){
                b.add(String.valueOf(c)+d);
            }
        }

        int common=0; //교집합 -> 같은 값이 있을 시 지우면서 탐색
        int sum=0; //합집합 -> 교집합을 제외한 리스트의 개수
      
        for (String s : a) {
            if (b.remove(s)){
                common+=1;
            }
            sum+=1;
        }
        for (String s : b) {
            sum+=1;
        }

        double zacad=(double)common/sum; //자카드 유사도

        //공집합일 경우 65536 리턴 
        cf)교집합이 있다면 합집합은 0일 수 없고, 교집합이 없어도 합집합은 있을 수 있으므로 교집합=0, 합집합=0 일 때 공집합
          
        if (common==0 && sum==0){
            answer=65536;
        }
        else{
            answer= (int) (zacad*65536);
        }
        return answer;
    }
}

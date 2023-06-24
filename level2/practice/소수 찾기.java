import java.util.*;
class Solution {
    public static HashSet<Integer> a;
    public static boolean []b=new boolean[7];
    public int solution(String numbers) {
        int answer = 0;

        a=new HashSet<>();

        for(int i=0;i<numbers.length();i++){
            dfs(numbers,"",i+1);
        }
        for (Integer integer : a) {

            boolean k=true;
            for(int i=2;i<integer;i++){
                if(integer%i==0){
                    k=false;
                    break;
                }
            }
            if(integer>1 && k){
                answer+=1;
            }
        }

        return answer;
    }
    //길이에 따른 문자를 수로 바꾸어 set에 추가함(중복 방지)
    static void dfs(String numbers,String tmp,int k){
        if(k==tmp.length()){
            a.add(Integer.parseInt(tmp));
        }
        for(int i=0;i<numbers.length();i++){
            if(!b[i]){
                b[i]=true;
                tmp+=numbers.charAt(i);

                dfs(numbers,tmp,k);
                b[i]=false;
                tmp=tmp.substring(0,tmp.length()-1);
            }
        }
    }
}

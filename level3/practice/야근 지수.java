import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Arrays.sort(works);
        
        while(true){
            if(n==0 || works[works.length-1]==0){
                break;
            }
            works[works.length-1]-=1;

            //Arrays.sort(배열) 이용시 시간초과 발생 ==> 범위 최소화
          
            for(int i=works.length-2;i>=0;i--){
                int tmp=0;
                if(works[i]<=works[i+1]){
                    break;
                }
                tmp=works[i+1];
                works[i+1]=works[i];
                works[i]=tmp;
            }
            n-=1;
        }
        
        for(int i=0;i<works.length;i++){
            answer+=Math.pow(works[i],2);
        }
        return answer;
    }
}

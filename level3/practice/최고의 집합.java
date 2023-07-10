class Solution {
    public int[] solution(int n, int s) {
        
        if(n>s || s==1){
            return new int[]{-1};
        }
        
        int[] answer = new int[n];       
        int i=0;
        while(n>0){
            
            int tmp=s/n; //합을 나눴을 때 몫이 가장 큰 수가 최고의 집합
            answer[i]=tmp;
            s-=tmp;
            i+=1;
            n-=1;
        }
        return answer;
    }
}

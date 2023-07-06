class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]>prices[j]){
                    answer[i]+=1; //가격이 기존 값 보다 떨어지면 떨어지지 않은 기간을 계산함
                    break;
                }
                answer[i]+=1;
            }
        }
        return answer;
    }
}

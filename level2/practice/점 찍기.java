class Solution {
    public long solution(int k, int d) {
        long answer = 0;
    
        for (int i = 0; i <= d; i += k) {
            long distance_xy=(long)(Math.sqrt((long)d*d-(long)i*i))/k+1; 
            //기준좌표인 d에서 k만큼의 좌표까지의 거리를 구하는 것과 같다. 이 때 거리가 같은 경우도 세야하므로 +1을 해준다.
            answer+=distance_xy;
        }
        return answer;
    }
}

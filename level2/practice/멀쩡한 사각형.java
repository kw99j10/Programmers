class Solution {
    public long solution(int w, int h) {
        
        long answer;

        long s = (long) w * h; //총 정사각형의 개수
        
        int k = gcd(w, h); //최대공약수
        long t = w + h - k; // ==> 사용하지 못하는 정사각형의 개수

        answer = s - t;
        
        return answer;
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int k = a % b;
            a = b;
            b = k;
        }
        return a;
    }   
}

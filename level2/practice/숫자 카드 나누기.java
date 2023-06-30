import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        //최대공약수 계산을 위한 두 배열 정렬
      
        Arrays.sort(arrayA); 
        Arrays.sort(arrayB);
        
        int gcd1=0;
        int gcd2=0;
         for (int k : arrayA) {
            gcd1 = gcd(gcd1, k);
        }
        for (int k : arrayB) {
            gcd2 = gcd(gcd2, k);
        }

        //gcd 대소 비교 & 최대 공약수를 이용하여 배열 중복 값 판단
      
        if (gcd2 > gcd1) {
            answer = gcd2;
        } 
        else if (gcd2 < gcd1) {
            answer = gcd1;
        }
        else{
            return 0;
        }

        boolean t = true;
        if (answer == gcd2) {
            for (int j : arrayA) {
                if (j % answer == 0) {
                    t = false;
                    break;
                }
            }
        }
        else if (answer == gcd1) {
            for (int j : arrayB) {
                if (j % answer == 0) {
                    t = false;
                    break;
                }
            }
        }
        if (!t) {
            answer = 0;
        }
        return answer;
    }
    static int gcd(int a,int b){
        
        while(b!=0){
            int r=a%b;
            
            a=b;
            b=r;

        }
        return a;
    }
}

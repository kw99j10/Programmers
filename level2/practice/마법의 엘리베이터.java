class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int n = storey % 10; //절댓값이 10c (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼들 이므로 현재 층수를 10으로 나눈 나머지를 확인

            
            if (n >= 6 || (n == 5 && storey / 10 % 10 >= 5)) {
                storey += 10 - n; //나머지가 6 이상 몫이 5인 수의 나머지가 5 이상인 경우 현재 층 수를 증가 시킨 후 더함
                answer += 10 - n;
            }
            else {
                answer += n; //나머지가 5이하, 몫이 5인 수의 나머지가 4이하인 경우는 현재 층 수를 그대로 더함
            }
            storey /= 10; 
        }
        
        return answer;
    }
}

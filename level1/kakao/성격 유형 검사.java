class Solution {
    public String solution(String[] survey, int[] choices) {
      
        //1번 지표
        int r = 0;
        int t = 0;

        //2번 지표
        int c = 0;
        int f = 0;

        //3번 지표
        int j = 0;
        int m = 0;

        //4번 지표
        int a = 0;
        int n = 0;
        
        String answer = "";
        
        //앞의 문자 1~3번 3,2,1점 , 뒤의 문자 5~7번 1,2,3점
        for (int i = 0; i < survey.length; i++) {
          
            //처음오는 문자가 비동의 관련 선택, 그 다음 문자는 동의 관련 선택지
            if (choices[i] <= 3) {
                if (survey[i].charAt(0) == 'A') {
                    a += 4 - choices[i];
                }
                else if (survey[i].charAt(0) == 'N'){
                    n += 4 - choices[i];
                }
                else if (survey[i].charAt(0) == 'R'){
                    r += 4 - choices[i];
                }
                else if (survey[i].charAt(0) == 'T'){
                    t += 4 - choices[i];
                }
                else if (survey[i].charAt(0) == 'C'){
                    c += 4 - choices[i];
                }
                else if (survey[i].charAt(0) == 'F'){
                    f += 4 - choices[i];
                }
                else if (survey[i].charAt(0) == 'J'){
                    j += 4 - choices[i];
                }
                else if (survey[i].charAt(0) == 'M'){
                    m += 4 - choices[i];
                }
            }
            else if (choices[i] >= 5) {
                if (survey[i].charAt(1) == 'R') {
                    r += choices[i] - 4;
                }
                else if (survey[i].charAt(1) == 'T'){
                    t += choices[i] - 4;
                }
                else if (survey[i].charAt(1) == 'C'){
                    c += choices[i] - 4;
                }
                else if (survey[i].charAt(1) == 'F'){
                    f += choices[i] - 4;
                }
                else if (survey[i].charAt(1) == 'J'){
                    j += choices[i] - 4;
                }
                else if (survey[i].charAt(1) == 'M'){
                    m += choices[i] - 4;
                }
                else if (survey[i].charAt(1) == 'A'){
                    a += choices[i] - 4;
                }
                else if (survey[i].charAt(1) == 'N'){
                    n += choices[i] - 4;
                }
            }
        }
        answer += r >= t ? "R" : "T";
        answer += c >= f ? "C" : "F";
        answer += j >= m ? "J" : "M";
        answer += a >= n ? "A" : "N";
        return answer;
    }
}

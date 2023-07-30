import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] total_time = new int[24 * 60+10]; //청소시간 10분 고려(cf:런타임 에러)

        for (String[] strings : book_time) {

            int in_time = getIn_time(strings); //입실시간
            int out_time = getOut_time(strings); //퇴실시간

            total_time[in_time] += 1; //입실 시 필요한 방 +1
            total_time[out_time + 10] -= 1;  //퇴실 시 방 -1
        }
        for (int i = 1; i < total_time.length; i++) {
            total_time[i] += total_time[i - 1];
            answer = Math.max(answer, total_time[i]); //누적합으로 총 필요한 방의 개수 구함
        }
        return answer;
    }
    //퇴실시간 계산 함수
    private static int getOut_time(String[] strings) {
        return Integer.parseInt(strings[1].split(":")[0]) * 60
                + Integer.parseInt(strings[1].split(":")[1]);
    }

    //입실시간 계산 함수
    private static int getIn_time(String[] strings) {
        return Integer.parseInt(strings[0].split(":")[0]) * 60
                + Integer.parseInt(strings[0].split(":")[1]);
    }
}

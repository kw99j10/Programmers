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


//2차 풀이
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] hotel = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            String[] tmp1 = getSplitTime(book_time[i], 0);
            hotel[i][0] = getSaveTime(tmp1); //대실 시작 시각 저장

            String[] tmp2 = getSplitTime(book_time[i], 1);
            hotel[i][1] = getSaveTime(tmp2); //대실 종료 시각 저장
        }

        //1. 대실 시작 시각 순 정렬
        Arrays.sort(hotel, Comparator.comparingInt(o -> o[0]));

        //2. 대실 종료 시각 순 정렬
        //시작 시각과 종료 시각을 비교하여 방을 생성할 list(queue) 생성
        PriorityQueue<int[]> room =
                new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        room.add(new int[]{hotel[0][0], hotel[0][1]});
        answer += 1;
        
        for (int i = 1; i < hotel.length; i++) {

            int next_start = hotel[i][0]; //다음 대실 시작 시각
            int next_end = hotel[i][1]; //다음 대실 종료 시각

            //현재 대실 종료 시각 + 10분(청소 시간) 과 다음 대실 시작 시간을 비교
            while (!room.isEmpty() && next_start >= room.peek()[1] + 10) {
                room.poll();
            }
            room.add(new int[]{next_start, next_end});
            answer = Math.max(answer, room.size());
        }
        return answer;
    }
    
    //시와 분을 나눔
    private static String[] getSplitTime(String[] book_time, int x) {
        return book_time[x].split(":");
    }

    //시간을 저장
    private static int getSaveTime(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}

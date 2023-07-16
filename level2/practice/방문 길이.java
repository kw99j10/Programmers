import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        var h=new HashSet<String>();

        //배열로 음수좌표를 표기하기 힘드므로 0~10의 좌표 판이라고 가정
      
        int x = 5; //현재 지점의 좌표
        int y = 5;

        int dis_x=5; //이동한 지점의 좌표
        int dis_y=5;

        for (int i = 0; i < dirs.length(); i++) {

            x=dis_x;
            y=dis_y;

            char c = dirs.charAt(i);

            //좌표의 이동조건 0<=x<=10, 0<=y<=10
            if ( c == 'U' ) {
                if ( y >= 10 ) {
                    continue;
                }
                dis_y += 1;
            }
            else if ( c == 'D' ) {
                if ( y == 0 ) {
                    continue;
                }
                dis_y -= 1;
            }
            else if ( c == 'R' ) {
                if ( x == 10 ) {
                    continue;
                }
                dis_x += 1;
            }
            else if ( c == 'L' ) {
                if ( x == 0 ) {
                    continue;
                }
                dis_x -= 1;
            }
            //현재 좌표에서 이동한 좌표로의 계산식이 없다면 방문길이 증가
            if (!h.contains("("+x + "," + y +")"+ "->" + "("+dis_x + "," + dis_y+")")){
                answer+=1;
            }
            //계산식을 더할 때
            //(1):현재 좌표 -> 이동한 좌표, (2): 이동한 좌표 -> 현재 좌표를 모두 저장하여 방문 길이 중복 방지
            //ex) LLRR의 방문길이는 2
            h.add("("+x + "," + y +")"+ "->" + "("+dis_x + "," + dis_y+")");
            h.add("("+dis_x + "," + dis_y +")"+ "->" + "("+x + "," + y+")");
        }
        return answer;
    }
}

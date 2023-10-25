import java.util.*;
class Solution {
       //이동한 (x,y)좌표와 이동횟수를 저장하는 Move 객체 생성
    static class Move{
        int move_x;
        int move_y;
        int count;
        public Move(int move_x, int move_y, int count) {
            this.move_x = move_x;
            this.move_y = move_y;
            this.count = count;
        }
    }
    static String[][] stage; //주어진 격자모양 게임판을 2차원 배열로 저장
    static int goal_x; //목적지 G의 x좌표
    static int goal_y; //목적지 G의 y좌표

    public static int solution(String[] board) {

        int start_x = 0, start_y = 0; //시작점 R

        stage = new String[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(j) == 'R') {
                    start_x = j;
                    start_y = i; //시작점 저장
                }
                if (s.charAt(j) == 'G') {
                    goal_x = j;
                    goal_y = i; //목적지 저장
                }
                stage[i][j] = String.valueOf(s.charAt(j));
            }
        }
        return bfs(start_x, start_y);
    }
    static int bfs(int start_x, int start_y) {
        Queue<Move> queue = new LinkedList<>(); //bfs를 위한 큐 구현
        boolean[][] visit = new boolean[stage.length][stage[0].length]; //방문을 확인할 배열

        //시작점 초기화
        visit[start_y][start_x] = true;
        queue.add(new Move(start_x, start_y, 0));

        while (!queue.isEmpty()) {
            Move current = queue.poll(); //현재 정보
            int x = current.move_x;
            int y = current.move_y;
            int count = current.count;

            //현재 좌표가 목적지 좌표라면 반복문을 종료
            if (x == goal_x && y == goal_y) {
                return count;
            }

            //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
            int[][] xy = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

            for (int[] ints : xy) {
                int distance_x = x + ints[0];
                int distance_y = y + ints[1];

                //게임판 안에 있으면서 장애물을 만나기 전까지 반복문을 실행함
                while ((distance_x >= 0 && distance_x < stage[0].length) &&
                        (distance_y >= 0 && distance_y < stage.length) &&
                        !stage[distance_y][distance_x].equals("D")) {
                    distance_x += ints[0];
                    distance_y += ints[1];
                }
                //게임판의 끝 또는 장애물에 도달했으면 이전 좌표로 이동
                distance_x -= ints[0];
                distance_y -= ints[1];

                //해당 좌표가 현재 좌표와 일치하거나 방문한 좌표면 큐에 저장 X
                if (visit[distance_y][distance_x] ||
                    (distance_x == x && distance_y == y)) {
                    continue;
                }
                visit[distance_y][distance_x] = true;
                queue.add(new Move(distance_x, distance_y, count + 1));
            }
        }
        return -1; //목적지 G에 도달할 수 없음
    }
}

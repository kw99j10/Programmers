import java.util.*;
//시작점 -> 레버, 레버 -> 목적지 bfs 2번 실행
class Solution {
    static char[][] maze;
    static boolean[][] visit; //방문을 확인할 배열
    static Queue<int[]> queue; //현재 좌표와 최소 칸 수를 담을 큐

    public int solution(String[] maps) {

        int start_x = 0; int start_y = 0; //시작 좌표를 저장
        int lev_x = 0; int lev_y = 0; //레버 좌표
        int goal_x = 0; int goal_y = 0; //목적지 좌표

        maze = new char[maps.length][maps[0].length()];

        //좌표를 저장
        for (int i = 0; i < maps.length; i++) {
            String tmps = maps[i];
            for (int j = 0; j < tmps.length(); j++) {
                if (tmps.charAt(j) == 'S') {
                    start_x = j;
                    start_y = i;
                }
                if (tmps.charAt(j) == 'L') {
                    lev_x = j;
                    lev_y = i;
                }
                if (tmps.charAt(j) == 'E') {
                    goal_x = j;
                    goal_y = i;
                }
                maze[i][j] = tmps.charAt(j);
            }
        }
        int startToLever = bfs(start_x, start_y, lev_x, lev_y);
        if (startToLever == -1) {
            return -1;
        }
        int levToExit = bfs(lev_x, lev_y, goal_x, goal_y);
        return levToExit == -1 ? -1 : startToLever + levToExit;
    }

    private static int bfs(int start_x, int start_y, int target_x, int target_y) {
        queue = new LinkedList<>();
        queue.add(new int[]{start_x, start_y, 0});
        visit = new boolean[maze.length][maze[0].length]; //방문 거리 배열 초기화
        //cf) 레버를 찾은 경우 출구를 찾기 위해 방문 거리 배열을 다시 초기화 해주어야 함

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int distance = poll[2];

            if (x == target_x && y == target_y) {
                return distance; // 목적지에 도달한 경우 최단 거리 반환
            }
            int[][] xy = new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};
            for (int[] ints : xy) {
                int distance_x = ints[0];
                int distance_y = ints[1];

                if (isTrue(distance_x, distance_y)) {
                    visit[distance_y][distance_x] = true;
                    queue.add(new int[]{distance_x, distance_y, distance + 1});
                }
            }
        }
        return -1; // 목적지에 도달하지 못했을 경우
    }

    private static boolean isTrue(int x, int y) {
        return x >= 0 && x < maze[0].length &&
                y >= 0 && y < maze.length &&
                maze[y][x] != 'X'
                && !visit[y][x];
    }
}

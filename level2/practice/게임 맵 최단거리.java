import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] dp = new int[maps.length][maps[0].length]; //최소 이동거리를 담는 배열
        boolean[][] b = new boolean[maps.length][maps[0].length]; //방문했는 지를 확인하는 배열
        Queue<int[]> q = new LinkedList<>(); x좌표, y좌표, 이동거리를 담는 리스트(큐)

        q.add(new int[]{0, 0, 1}); //캐릭터가 시작하는 위치
        b[0][0] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int distance = tmp[2];
            dp[y][x] = distance;

            int[][] xy = {{x - 1, y}, {x + 1, y}, {x, y + 1}, {x, y - 1}};

            for (int[] ints : xy) {
                int dis_x = ints[0];
                int dis_y = ints[1];

                  //게임 맵을 벗어나지 않아야 함 && 벽이 아니어야 함 && 방문하지 않았어야 함 ==> 큐에 (이동한 거리의 좌표를)더함
                  if ((dis_x >= 0 && dis_x < maps[0].length) && (dis_y >= 0 && dis_y < maps.length)
                        && (maps[dis_y][dis_x] == 1) && !b[dis_y][dis_x]) {
                    q.add(new int[]{dis_x, dis_y, distance + 1});
                    b[dis_y][dis_x] = true;
                }
            }
        }
        answer = dp[maps.length - 1][maps[0].length - 1] == 0 ? -1 : dp[maps.length - 1][maps[0].length - 1]; //마지막 값이 0이라면 상대편 진영에 가지 못한 경우 이므로 -1을 return
        return answer;
    }
}

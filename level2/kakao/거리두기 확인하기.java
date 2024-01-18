import java.util.*;
class Solution {
    static int[][] frontAndBack = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //앞뒤 1칸의 경우
    static int[][] frontAndBackTwo = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}}; //앞뒤 2칸의 경우
    static int[][] cross = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}}; //대각선의 경우

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        ArrayList<Boolean> check = new ArrayList<>(); //거리두기를 지켰는 지 정보를 담을 리스트

        for (String[] place : places) {
            char[][] wait = new char[5][5]; //각 대기실의 크기 5x5

            for (int i = 0; i < place.length; i++) {
                wait[i] = place[i].toCharArray();
            }

            //맨해튼 거리(Math.abs(r1-r2)+Math.abs(c1-c2)) 2이하일 때 거리두기 준수 X
            boolean follow = conform(wait);
            check.add(follow);
        }

        for (int i = 0; i < check.size(); i++) {
            answer[i] = check.get(i) ? 1 : 0; //거리두기를 지켰으면 1, 아니면 0
        }
        return answer;
    }
    static boolean conform(char[][] wait) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (wait[i][j] == 'P') {
                    //1. 응시자가 앞뒤 1칸 간격으로 있을 경우
                    for (int k = 0; k < 4; k++) {
                        int nx = frontAndBack[k][0] + i;
                        int ny = frontAndBack[k][1] + j;

                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                            if (wait[nx][ny] == 'P') {
                                return false; //1칸 내에 응시자가 있으면 거리두기 준수 x
                            }
                        }
                    }

                    //2. 응시자가 앞뒤 2칸 간격으로 있을 경우
                    for (int k = 0; k < 4; k++) {
                        int nx = frontAndBackTwo[k][0] + i;
                        int ny = frontAndBackTwo[k][1] + j;

                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                            if (wait[nx][ny] == 'P' && (wait[(i + nx) / 2][(j + ny) / 2] == 'O')) {
                                return false; //2칸 내에 빈 테이블이 존재한다면 거리두기 준수 X
                            }
                        }
                    }

                    //3. 응시자가 대각선으로 있을 경우
                    for (int k = 0; k < 4; k++) {
                        int nx = cross[k][0] + i;
                        int ny = cross[k][1] + j;

                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                            if (wait[nx][ny] == 'P' && (wait[nx][j] == 'O' || wait[i][ny] == 'O')) {
                                return false; //대각선 사이에 테이블이 하나라도 존재한다면 거리두기 준수 X
                            }
                        }
                    }   
                }
            }
        }
        return true;
    }
}

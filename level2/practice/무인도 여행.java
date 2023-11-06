import java.util.*;
class Solution {
    static ArrayList<Integer>a; //버틸 수 있는 최대 날짜를 담을 누적 List
    public int[] solution(String[] maps) {
        
        int [][]map=new int[maps.length][maps[0].length()]; //입력값(무인도에서 버틸 수 있는 날짜)을(를) 담을 2차원 배열

        for(int i=0;i<maps.length;i++){
            String []tmp=maps[i].split("");
            for (int j = 0; j < tmp.length; j++) {
                
                if(tmp[j].equals("X")){
                    map[i][j]=-1; //바다일 때는 제외
                }
                else{
                    map[i][j] = Integer.parseInt(tmp[j]); //X가 아닌 1~9일 경우 대입
                }
            }
        }
        boolean [][] visit=new boolean[map.length][map[0].length]; //방문을 확인할 배열
        a=new ArrayList<>();
        
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]!=-1 && !visit[i][j]){
                    a.add(0); 
                    
                    dfs(visit,i,j,map); //방문하지 않았거나 바다가 아니면 0을 넣고 dfs 탐색 시작
                }
            }
        }
        if(a.size()==0){
            return new int[]{-1}; //무인도가 없다면 -1을 return
        }
        Collections.sort(a);
        int []answer=new int[a.size()];
        for(int i=0;i<a.size();i++){
            answer[i]=a.get(i);
        }
        return answer;
    }
    static void dfs(boolean [][]visit,int i,int j,int [][]map){
        
        if(i<0 || i>map.length-1 || j<0 || j>map[0].length-1){
            return; //배열 범위를 넘어간 경우 제외
        }
        if(map[i][j]==-1 || visit[i][j]){
            return; //방문 했거나 바다인 경우 제외
        }
        visit[i][j]=true; //아닐 경우 해당 무인도 방문
        
        // 리스트의 마지막 요소에 현재 버틸 수 있는 날짜를 누적
        int val = a.get(a.size()-1);
        val += map[i][j];
        a.set(a.size()-1, val);

        //조건에 따라 top,bottom,left,right 방문
        dfs(visit,i+1,j,map);
        dfs(visit,i-1,j,map);
        dfs(visit,i,j+1,map);
        dfs(visit,i,j-1,map);
    }
}

//풀이 2
import java.util.*;
class Solution {
    static int[][] island;
    static int day_count;

    public int[] solution(String[] maps) {

        island = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            String s = maps[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == 'X') {
                    island[i][j] = 0; // X -> 0으로 치환
                }
                else{
                    island[i][j] = Integer.parseInt(String.valueOf(c));
                }
            }
        }
        var days = new ArrayList<Integer>(); //머무를 수 있는 날짜

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {

                if (island[i][j] != 0) {
                    day_count = 0;
                    dfs(i, j);
                    days.add(day_count);
                }
            }
        }
        Collections.sort(days);
        int[] answer = new int[days.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = days.get(i);
        }
        return days.size() != 0 ? answer : new int[]{-1};
    }

    private void dfs(int i, int j) {
        
        day_count += island[i][j];
        island[i][j] = 0;

        //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
        int[][] xy = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

        for (int[] ints : xy) {
            int distance_y = ints[0];
            int distance_x = ints[1];

            // 이동한 좌표가 미로 안에 있어야 하며,
            // 그 좌표는 1(이동할 수 있는 칸)이어야 함
            if (distance_x >= 0 && distance_x <= island[0].length - 1 &&
                    distance_y >= 0 && distance_y <= island.length - 1) {
                if (island[distance_y][distance_x] != 0) {
                    dfs(distance_y, distance_x);
                }
            }
        }
    }
}

#1 dfs 풀이
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n]; //방문 여부 확인 배열
        for(int i = 0; i < n; i++) {
            if(!chk[i]) {
                dfs(computers, chk, i); //방문하지 않았다면 dfs 실행
                answer++;
            }
        }
        return answer;
    }
    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i); //노드끼리 연결되어 있고 방문하지 않았다면 dfs 실행
            }
        }
    }
}

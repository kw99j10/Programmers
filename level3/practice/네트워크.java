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

# 2 bfs 풀이
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean []b=new boolean[n];
        var q=new LinkedList<Integer>(); 
        
        //bfs
        for(int j=0;j<n;j++){
            q.add(j); //queue에 index 순으로 삽입
            
            if(b[j]){
                continue; //현재 node의 연결 여부를 확인
            }
            b[j]=true;
            
            while(!q.isEmpty()){
                int tmp=q.poll();
                for (int i=0;i<computers[tmp].length;i++){
                    if (computers[tmp][i]==0 || b[i]){
                        continue; //연결되지 않았거나 이미 방문 했으면 검사에서 제외
                    }
                    q.add(i); //연결된 노드를 queue에 넣고 while문 실행
                    b[i]=true; //방문 확인
                }
            }
            answer+=1; //반복문의 종료=네트워크 수
        }
        return answer;
    }
}

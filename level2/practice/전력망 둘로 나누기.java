import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n; //초기값은 송전탑의 개수
        
        int [][]tmp=new int[n+1][n+1]; //인접 행렬 구현
        for(int i=0;i<wires.length;i++){
            tmp[wires[i][0]][wires[i][1]]=1;
            tmp[wires[i][1]][wires[i][0]]=1;
        }
        
        //전선을 끊을 변수
        int a=0;
        int b=0;
        
        for(int i=0;i<wires.length;i++){
            
            a=wires[i][0];
            b=wires[i][1];
            
            //전력망을 끊음
            tmp[a][b]=0;
            tmp[b][a]=0;
            
            
            //bfs 탐색
            int []visit=new int[n+1];
            int count=1;
            
            var q=new LinkedList<Integer>();
            q.offer(a);
            
            while(!q.isEmpty()){
                int point= q.poll();
                visit[point]=1;

                for(int j=1; j<=n; j++){ 
                    if(visit[j]==1){
                        continue;
                    }

                    if(tmp[point][j]==1) {
                        q.offer(j);
                        count+=1;
                    }
                }
            }
            
            answer=Math.min(answer,Math.abs(count-(n-count))); //연결 차의 최솟값
            
            //전력망을 다시 붙임
            tmp[a][b]=1;
            tmp[b][a]=1;
        }
        return answer;
    }
}

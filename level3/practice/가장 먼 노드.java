import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(); //인접리스트를 구현하기 위한 자료구조

        for(int i=0;i<=n;i++){
            a.add(new ArrayList<>()); //각 노드별 리스트 생성
        }

        for(int i=0;i<edge.length;i++){
            a.get(edge[i][0]).add(edge[i][1]);
            a.get(edge[i][1]).add(edge[i][0]); //양방향 그래프이므로
        }

        for(int i=0;i<a.size();i++){
            Collections.sort(a.get(i)); //노드 번호 순서대로 구하기 위한 요소 정렬
        }
        var q = new LinkedList<Integer>();      
        boolean[] visit = new boolean[n + 1]; //방문한 노드 확인여부 배열
        int []dis=new int[n+1]; //노드별 거리를 담을 배열(1기준)
        
        q.offer(1); //1을 넣고 시작
        visit[1] = true;      

        //인접노드별 길이 구하기
        while(!q.isEmpty()){
            
            int tmp=q.poll();
            
            ArrayList<Integer> t=a.get(tmp);
            for(int i=0;i<t.size();i++){
                if (!visit[t.get(i)]) {
                    visit[t.get(i)]=true;
                    q.add(t.get(i));
                    dis[t.get(i)]=dis[tmp]+1;
                }
            }
        }
        Arrays.sort(dis); //가장 먼 노드 구하기 위
        int max=dis[dis.length-1];
        for(int i=dis.length-1;i>=0;i--){
            if(dis[i]==max){
                answer+=1;
            }     
        }
        return answer;
    }
}

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

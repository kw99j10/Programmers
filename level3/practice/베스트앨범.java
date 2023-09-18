import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        //{장르:장르 재생 횟수}
        var gen_count=new HashMap<String,Integer>();

        for (int i = 0; i < genres.length; i++) {
            gen_count.put(genres[i], gen_count.getOrDefault(genres[i], 0) + plays[i]);
        }

        //많이 재생된 장르 순으로 수록
        var a = new ArrayList<>(gen_count.entrySet());
        a.sort((o1, o2) -> o2.getValue() - o1.getValue());

        //{고유번호:해당 고유번호 노래의 재생된 횟수}
        var play_count = new HashMap<Integer, Integer>();

        for (int i = 0; i < genres.length; i++) {
            play_count.put(i, plays[i]);
        }

        //장르 내에서 많이 재생된 노래 순으로 수록
        var c = new ArrayList<>(play_count.entrySet());
        c.sort((o1, o2) -> o2.getValue() - o1.getValue());

        //정렬 확인
        /*for (Map.Entry<String, Integer> entry : a) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : c) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }*/
      
        var genreList = new ArrayList<>(Arrays.asList(genres)); //장르에 해당하는 노래 일치여부 확인
        
        var ans = new ArrayList<Integer>(); //answer 배열에 넣을 list 변수
        for (Map.Entry<String, Integer> genreEntry : a) {

            int count = 2; //가장 많이 재생된 노래 2개 제한

            for (Map.Entry<Integer, Integer> songEntry : c) {
                if (genreList.get(songEntry.getKey()).equals(genreEntry.getKey())) {
                    ans.add(songEntry.getKey()); //고유번호를 저장
                    count -= 1;

                    if (count == 0) {
                        break;
                    }
                }
            }
        }
        
        int[] answer = new int[ans.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}

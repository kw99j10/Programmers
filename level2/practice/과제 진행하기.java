import java.util.*;
class Solution {
    
    //이해하기 쉽도록 과제의 이름, 시작 시간, 플레이 시간을 한 번에
    //갱신 하기 위해 클래스 & 생성자(객체) 생성
    static class Subject{
        String name;
        int start;
        int play;

        public Subject(String name, int start, int play) {
            this.name = name;
            this.start = start;
            this.play = play;
        }
    }
    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        //각 작업, 시작 시간, 플레이 시간을 담을 리스트
        List<Subject> list=new ArrayList<>();
        for (String[] plan : plans) {
            String name=plan[0];
            String[] time=plan[1].split(":");
            int start= Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            int play=Integer.parseInt(plan[2]);

            list.add(new Subject(name,start,play));
        }
        list.sort(Comparator.comparingInt(o->o.start)); //시작 시간 순 정렬

        Stack<Subject> s=new Stack<>(); //진행 중인 작업을 담을 스택
        s.push(list.get(0));
        int current=list.get(0).start; //현재 작업 시작 시간
        int index=0; //현재 인덱스

        for (int i=1;i<plans.length;i++){

            int next=list.get(i).start; //다음 작업 시작 시간

            while (!s.isEmpty()){
                Subject subject = s.pop();
                String name= subject.name;;
                int start=subject.start;
                int play=subject.play;

                //만약 시작 시간이 현재 시간 보다 크다면 동기화
                if (start>current){
                    current=start;
                }

                //종료 시간은 시작 시간 + 플레이 시간
                int end=current+play;

                //종료 시간이 다음 시작 시간보다 크다면 다시 스택에 저장
                //다음 일 부터 시작 하기 위해 break
                if (end>next){
                    int remain=end-next;
                    s.push(new Subject(name,start,remain));
                    current=next;
                    break;
                }
                //아니라면 종료 배열에 끝난 작업의 이름을 저장
                else{
                    answer[index]=name;
                    index+=1;
                    current+=play;
                }
            }
            s.push(list.get(i));
        }

        //아직 작업이 남아있다면
        while (!s.isEmpty()){
            answer[index]=s.pop().name;
            index+=1;
        }

        return answer;
    }
}

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
       
        while (true) {
            
            ////a와 b가 만나기 위해서는 번호차이가 1이어야 한다. 그리고 a,b중 최댓값은 2의 배수여야 한다.
            if (Math.abs(a - b) == 1 && Math.max(a, b) % 2 == 0) {
                break;
            }
            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;
            answer += 1;
            System.out.println(a + " " + b);
        }
        return answer;
    }
}

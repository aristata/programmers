package aristata.programmers.d20190316;

public class SumOfDivisors {
    public static void main(String[] args) {
        SumOfDivisors a = new SumOfDivisors();
        int result = a.solution(12);
        System.out.println();
        System.out.println(result);
    }

    private int solution(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                System.out.print(i + " ");
            answer += i;
        }
        return answer;
    }
}

package aristata.programmers.d20190316;

public class ChangeInteger {

    public static void main(String[] args) {
        ChangeInteger changeInteger = new ChangeInteger();

        String testCase1 = "1234";
        System.out.println(changeInteger.solution(testCase1));

        String testCase2 = "-1234";
        System.out.println(changeInteger.solution(testCase2));
    }

    private int solution(String s) {
        return Integer.parseInt(s);
    }
}

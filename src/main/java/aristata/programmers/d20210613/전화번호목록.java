package aristata.programmers.d20210613;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 전화번호목록 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // TestCase1
        String[] input1 = {"119", "97674223", "1195524421"};
        boolean answer1 = false;
        boolean result1 = sol.solution(input1);
        boolean isPass1 = answer1 == result1;
        String message1 = "TestCase1 >>> answer1 = '" + answer1 + "', result1 = '" + result1 + "' >>> " + isPass1 + "!!!";
        System.out.println(message1);

        // TestCase2
        String[] input2 = {"123", "456", "789"};
        boolean answer2 = true;
        boolean result2 = sol.solution(input2);
        boolean isPass2 = answer2 == result2;
        String message2 = "TestCase2 >>> answer2 = '" + answer2 + "', result2 = '" + result2 + "' >>> " + isPass2 + "!!!";
        System.out.println(message2);

        // TestCase3
        String[] input3 = {"12", "123", "1235", "567", "88"};
        boolean answer3 = false;
        boolean result3 = sol.solution(input3);
        boolean isPass = answer3 == result3;
        String message3 = "TestCase3 >>> answer3 = '" + answer3 + "', result3 = '" + result3 + "' >>> " + isPass + "!!!";
        System.out.println(message3);
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            // 접두사의 길이는 전체 글자수의 길이보다 작거나 같을 것이다. ⇒ 길이순으로 정렬을 하면 좀 더 빨리 찾지 않을까?
            // 반복문을 돌면서 접두사가 맞으면 true, 아니면 false 값을 해쉬에 담는다.

            // 해쉬맵 생성
            HashMap<String, Boolean> phoneMap = new HashMap<>();

            // 배열을 일단 해쉬맵에 담음
            Arrays.stream(phone_book).forEach(it -> {
                boolean isPrefix =

                phoneMap.put(it, false);
            });


            // 해쉬에서 true 값이 있으면 false 를 정답으로 리턴한다.

            return answer;
        }
    }
}

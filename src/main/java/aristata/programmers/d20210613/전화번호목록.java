package aristata.programmers.d20210613;


import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

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
            // 접두사의 길이는 전체 글자수의 길이보다 작거나 같을 것이다. ⇒ 길이순으로 정렬을 하면 좀 더 빨리 찾지 않을까?
            // 반복문을 돌면서 접두사가 맞으면 true, 아니면 false 값을 해쉬에 담는다.

            // 해쉬셋 생성
            HashSet<String> phoneSet = new HashSet<>();

            // 해쉬셋에 데이터 담기
            phoneSet = (HashSet<String>) Arrays.stream(phone_book).collect(Collectors.toSet());

            // 반복문
            HashSet<String> finalPhoneSet = phoneSet;
            for (String key : phoneSet) {
                for (int i = 1; i <= key.length() - 1; i++) {
                    if (finalPhoneSet.contains(key.substring(0, i))) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}

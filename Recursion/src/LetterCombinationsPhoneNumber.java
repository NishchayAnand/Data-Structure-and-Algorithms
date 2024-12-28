import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    Problem Statement: Given a string 'digits' containing digits from 2-9 inclusive, return all
                       possible letter combinations that the number could represent.

                       NOTE: Return the answer in any order.

    Example: For digits = "23" where '2':"abc" and '3':"def", return output: ["ad","ae","af","bd","be",
             "bf","cd","ce","cf"]

    General Observations:




*/

public class LetterCombinationsPhoneNumber {

    private void getAllCombinations(Map<Character, String> map, String digits, int index, char[] combination, List<String> combinations) {

        if(index == digits.length()){
            combinations.add(new String(combination));
            return;
        }

        String letters = map.get(digits.charAt(index));
        for(int i=0; i<letters.length(); i++) {
            combination[index] = letters.charAt(i);
            getAllCombinations(map, digits, index+1, combination, combinations);
        }

    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> combinations = new ArrayList<>();
        if(!digits.isEmpty()) {
            char[] combination = new char[digits.length()];
            getAllCombinations(map, digits, 0, combination, combinations);
        }
        return combinations;
    }
}

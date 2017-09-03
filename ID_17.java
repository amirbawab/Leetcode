/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is ~given below~.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 **/
class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] map = {
            {},{},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };
        List<String> list = new ArrayList<>();
        genNumbers(map, list, digits, 0, "");
        return list;
    }
    
    public void genNumbers(char[][] map, List<String> list, String digits, int index, String result) {
        if(index == digits.length()) {
            if(result.length() != 0) {
                list.add(result);    
            }
        } else {
            for(int i=0; i < map[digits.charAt(index) - '0'].length; i++) {
                genNumbers(map, list, digits, index+1, result + map[digits.charAt(index)-'0'][i]);
            }
        }
    }
}

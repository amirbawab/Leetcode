/**
 * Link: https://leetcode.com/problems/zigzag-conversion/description/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * */
class Solution {
    public String convert(String s, int rows) {
        if(rows == 1) {
            return s;
        }
        // Create string builders
        StringBuilder[] sbs = new StringBuilder[rows];
        for(int i=0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        // Initi coordinates
        int y=0;
        int index=0;
        boolean dirDown = true;
        while(index < s.length()) {
            sbs[y].append(s.charAt(index++));
            if(dirDown && y == rows-1) {
                dirDown = false;
                y = rows-2;
            } else if(!dirDown && y == 0) {
                dirDown = true;
                y = 1;
            } else if(dirDown) {
                y++;
            } else {
                y--;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i < sbs.length; i++) {
            result.append(sbs[i].toString());
        }
        return result.toString();
    }
}

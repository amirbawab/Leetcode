/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * 
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * Note: All inputs will be in lower-case.
 **/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Sort strings by lexically
        String[] sorted = new String[strs.length];
        for(int i=0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sorted[i] = new String(chars);
        }
        
        // Find the ones that match
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i < sorted.length; i++) {
            if(!map.containsKey(sorted[i])) {
                List<String> list = new ArrayList<String>();
                map.put(sorted[i], list);
                result.add(list);
            }
            map.get(sorted[i]).add(strs[i]);
        }
        return result;
    }
}

/**
 * Better solution, unknow author (from top java submission)
 * */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // https://primes.utm.edu/lists/small/1000.txt
        int[] prime = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101
        };

        List<List<String>> ret = new ArrayList<List<String>>();
        HashMap<Integer, List<String>> m = new HashMap<>();

        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            if (!m.containsKey(key)) {
                List<String> l = new ArrayList<String>();
                l.add(s);
                ret.add(l);
                m.put(key, l);
            } else {
                List<String> l = m.get(key);
                l.add(s);
            }
        }

        return ret;
    }
}

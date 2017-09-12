/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        // Check if the list is empty
        if(intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        // for(int i=0; i < intervals.size(); i++) {
        //     System.out.println(intervals.get(i).start + ":" + intervals.get(i).end);
        // }   
        
        // Prepare the result list
        List<Interval> list = new ArrayList<>();
        int low = intervals.get(0).start;
        int high = intervals.get(0).end;
        int current = 1;
        while(current < intervals.size()) {
            if(high >= intervals.get(current).start) {
                high = Math.max(high, intervals.get(current).end);
            } else {
                list.add(new Interval(low, high));
                low = intervals.get(current).start;
                high = intervals.get(current).end;
            }
            current++;
        }
        list.add(new Interval(low, high));
        
        return list;
    }
}

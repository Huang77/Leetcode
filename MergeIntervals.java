package LeetCode;

import java.util.ArrayList;
import java.util.List;


public class MergeIntervals {
	public static void main (String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,3));
		list.add(new Interval(2,6));
		list.add(new Interval(8,10));
		list.add(new Interval(15,18));
		list = merge(list);
	    
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		List<Interval> result = new ArrayList<Interval>();
        quickSort(intervals, 0, intervals.size() - 1);
        
       int i = 1;
       Interval cur = intervals.get(0);
       while (i < intervals.size()) {
    	   if (intervals.get(i).start > cur.end) {
    		   result.add(cur);
    		   cur = intervals.get(i);
    	   } else {
    		   cur.start = Math.min(intervals.get(i).start, cur.start);
    		   cur.end = Math.max(intervals.get(i).end, cur.end);
    	   }
    	   i++;
       }
       result.add(cur);
       return result;
        
    }
	
	
	public static void quickSort (List<Interval> list, int start, int end) {
		int pivot;
		if (start < end) {
			pivot = partition(list, start, end);
			quickSort(list, start, pivot - 1);
			quickSort(list, pivot + 1, end);
		}
	}
	public static int partition (List<Interval> list, int start, int end) {
		Interval pivotObj = list.get(start);
		while (start < end) {
			while (start < end && list.get(end).start >= pivotObj.start) {
				end--;
			}
			swap(list, start, end);
			while (start < end && list.get(start).start <= pivotObj.start) {
				start++;
			}
			swap(list, start, end);
		}
		return start;
	}
	
	public static void swap (List<Interval> list, int index1, int index2) {
		Interval temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
}


class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}



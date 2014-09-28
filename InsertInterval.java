package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static void main (String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,5));
		//list.add(new Interval(3,5));
		//list.add(new Interval(6,7));
		//list.add(new Interval(8,10));
		//list.add(new Interval(12,16));
		Interval newInterval = new Interval(7,8);
		list = insert(list, newInterval);
	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
        	return intervals;
        }
        List<Interval> newList = new ArrayList<Interval>();
        if (intervals == null || intervals.size() <= 0) {
        	newList.add(newInterval);
        	return newList;
        }
        Interval temp = null;
        int i = 0;
        for (; i < intervals.size(); i++) {
        	temp = intervals.get(i);
        	if (temp.end < newInterval.start) {
        		newList.add(temp);
        	} else {
        		break;
        	}
        }

            for (; i < intervals.size(); i++) {
            	if (newInterval.end < intervals.get(i).start) {
            		newList.add(newInterval);
            		break;
            	} else {
                    newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                    newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            	}
            }
            if (i == intervals.size()) {
            	newList.add(newInterval);
            } else {
                while (i < intervals.size()) {
                	newList.add(intervals.get(i));
                	i++;
                }
            }

        return newList;
    }
}

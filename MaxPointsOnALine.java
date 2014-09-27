package LeetCode;

import java.util.HashMap;
import java.util.Iterator;


// Definition for a point.
class Point {
   int x;
   int y;
   Point() { 
	   x = 0; 
	   y = 0; 
   }
   Point(int a, int b) { 
	   x = a; 
	   y = b; 
   }
}

public class MaxPointsOnALine {
	public static void main (String[] args) {
		Point[] points = new Point[9];
		points[0] = new Point(84,250);
		points[1] = new Point(1,0);
		points[2] = new Point(0,-70);
		points[3] = new Point(0,-70);
		points[4] = new Point(1,-1);
		points[5] = new Point(21,10);
		points[6] = new Point(42,90);
		points[7] = new Point(-42,-230);
		points[8] = new Point(0,0);
		
		int result = maxPoints(points);
		System.out.println(result);
	}
    public static int maxPoints(Point[] points) {
        if (points == null) {
        	return 0;
        }
        if (points.length <= 2) {
        	return points.length;
        }
        int size = points.length;
        HashMap<Double, Integer> kCounts = new HashMap<Double, Integer>();
        int max = 0;
        int samePointCount;
        double k;
        
        for (int i = 0; i < size; i++) {
        	kCounts.clear();
        	samePointCount = 1;
        	for (int j = 0; j < size; j++) {
        		if (i == j) {
        			continue;
        		}
        		if (points[i].x == points[j].x && points[i].y == points[j].y) {
        			samePointCount++;
        		} else {
            		if (points[i].x == points[j].x) {
            			k = Double.MAX_VALUE;
            		} else {
            			k = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
            		}
            		if (kCounts.containsKey(k)) {
            			kCounts.put(k, kCounts.get(k) + 1);
            		} else {
            			kCounts.put(k, 1);
            		}
        		}
        	}
        	if (samePointCount > max) {
        		max = samePointCount;
        	}
        	Iterator<Integer> iter = kCounts.values().iterator();
        	int temp;
        	while (iter.hasNext()) {
        		temp = iter.next() + samePointCount;
        		if (temp > max) {
        			max = temp;
        		}
        	}
        }
        return max;
    }
}

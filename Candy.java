package LeetCode;

/**
 * Problem:
 * There are N children standing in a line. Each child is assigned a rating value.
	You are giving candies to these children subjected to the following requirements:
	1. Each child must have at least one candy.
	2. Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?
 * 
 * Solution:
 * Traverse from the start to end, set the first child should get 1 candy, end if the next child rates more than the previous then he gets 
 * one more candy than the previous one, else he gets 1 candy too. This forward traversal guarantee that if the child rates more than the previous 
 * one, he gets more candy than the previous one.
 * Then, traverse from the end to start, if the child rates more than his next one but the number of candy he gets is no more than his next one,
 * than make the number of candy he gets one more than his next one. The backward traversal guarantee that if the child rates more than next child,
 * he gets more candy than the next one;
 * Finally, return the total number of candy;
 * 
 * @author HXX
 *
 */

public class Candy {
	public static void main (String[] args) {
		int[] ratings = {1,2,11,1};
		System.out.println(candy(ratings));
	}
	
	public static int candy (int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		} 
		if (ratings.length == 1) {
			return 1;
		}
		int[] candyNum = new int[ratings.length];
		candyNum[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candyNum[i] = candyNum[i - 1] + 1;
			} else {
				candyNum[i] = 1;
			}
		}
		int sum = candyNum[candyNum.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && candyNum[i] <= candyNum[i + 1]) {
				candyNum[i] = candyNum[i + 1] + 1;
			}
			sum += candyNum[i];
		}
		return sum;
	}
}

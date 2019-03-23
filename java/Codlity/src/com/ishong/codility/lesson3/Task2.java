package com.ishong.codility.lesson3;

import java.util.Arrays;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Task2 {
	public static int solution(int[] A) {
        // write your code in Java SE 8
		Arrays.parallelSort(A);
		int prev = 0;
		
		for (int i = 0; i < A.length; i++) {
			int cur = A[i];
			
			if (prev + 1 != cur)
				break;
			
			prev = cur;
		}
		
		return prev + 1;
    }
}

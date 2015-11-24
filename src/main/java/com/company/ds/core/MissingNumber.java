package com.company.ds.core;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class MissingNumber {
	private static Logger log = LoggerFactory.getLogger(MissingNumber.class); 
	public int getMissingNumber_1(int[] a, int n){ 
		int total = ((n+2)*(n+1))/2; 
		for(int i=0; i< a.length; i++){ 
			total -=a[i]; 
			log.info(""+total); 
		} 
		return total; 
	} 
	public int getMissingNumber_2(int[] a, int n){ 
		int i; 
		int x1 = a[0]; 
		int x2 = 1; 
		for(i = 1; i < n; i++) 
			x1 = x1^a[i]; 
		for(i=2; i <=n+1; i++) 
			x2 = x2^i; 
		return (x1^x2); 
	} 
	public static void main(String[] args) { 
		int[] a = {1,2,4,5,6}; 
		MissingNumber miNumber = new MissingNumber(); 
		log.info(" The Missing Number in the array "+miNumber.getMissingNumber_2(a,a.length)); 
	} 
}
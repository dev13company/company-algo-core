package com.company.ds.core;

import java.util.Arrays; 
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
public class DuplicateNumber {

	public static void main(String[] args) { 
		int[] values = new int[100]; 
		Random random = new Random(); 
		int rand = Math.abs(random.nextInt() % 100); 
		for(int i=0; i< 100; i++){ 
			if( rand == i+1){ 
				values[i] = rand; 
				continue; 
			}else{ 
				values[i] = 99-i; 
			} 
		} 
		// System.out.println(rand +" Initial Array "+ Arrays.asList(ArrayUtils.toObject(values))); 
		boolean[] barr = new boolean[values.length]; 
		for(int i=0; i < values.length; i++){ 
			// System.out.println(barr[values[i]]+" "+values[i]); 
			barr[values[i]] = (!barr[values[i]]==true)?true:false; 
			if(!barr[values[i]]) 
				System.out.println(" Duplicate Number "+values[i]); 
		} 
		// System.out.println(" Final Array "+ Arrays.asList(ArrayUtils.toObject(barr))); 
	} 
}



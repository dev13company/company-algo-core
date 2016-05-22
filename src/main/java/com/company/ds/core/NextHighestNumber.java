package com.company.ds.core;
import java.util.Arrays; 
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
public class NextHighestNumber {

	public int getNextHN(int n){ 
		if(checkReversed(n)) 
			return -1; 
		if(checkOrdered(n)){ 
			char[] l2digits = new char[2]; 
			System.arraycopy(String.valueOf(n).toCharArray(), String.valueOf(n).toCharArray().length-2, l2digits, 0, 2);
			// (String.valueOf(n).toCharArray( System.out.println(" characters "+Arrays.asList(ArrayUtils.toObject(l2digits))); 
			/*char[] digits = String.valueOf(n).toCharArray() 
StringBuffer sb = new StringBuffer(); 
for(int i=0; i<digits)*/ 
			StringBuffer sb = new StringBuffer(String.valueOf(n).substring(0, String.valueOf(n).toCharArray().length-2)); 
			sb.append(l2digits[1]); 
			sb.append(l2digits[0]); 
			return Integer.parseInt(sb.toString()); 
		}else{ 
			char[] digits = String.valueOf(n).toCharArray(); 
			int i=0; 
			int d = 0; 
			for(i=digits.length -1; i>=0; i--){ 
				if(Integer.parseInt(String.valueOf(digits[i]))-Integer.parseInt(String.valueOf(digits[i-1]))>0){ 
					d = Integer.parseInt(String.valueOf(digits[i-1])); 
					break; 
				} 
			} 
			if(i==0)
				return -1; 
			int l=i-1; 
			int min = Integer.MAX_VALUE; 
			int index =-1; 
			int j=0; 
			for(j=i; j< digits.length;j++){ 
				if(min > Integer.parseInt(String.valueOf(digits[j]))){ 
					min = Integer.parseInt(String.valueOf(digits[j])); index = j; 
				} 
			} 
			// System.out.println(" min value "+min +" index "+j); 
			char temp = digits[l]; 
			digits[l] = digits[index]; 
			digits[index] = temp; 
			char[] sdigits = new char[digits.length-i]; 
			System.arraycopy(digits, i, sdigits, 0, digits.length-i); 
			Arrays.sort(sdigits);
			// System.out.println(" sub Digits "+ Arrays.asList(ArrayUtils.toObject(sdigits))); 
			StringBuffer sb = new StringBuffer(); 
			for(int m=0; m<l+1;m++){ 
				sb.append(digits[m]); 
			} 
			for(int o=0; o<sdigits.length; o++){ 
				sb.append(sdigits[o]); 
			} 
			return Integer.parseInt(sb.toString()); 
		} 
		// return 0; 
	} 
	private boolean checkOrdered(int n) { 
		char[] digits = String.valueOf(n).toCharArray(); 
		boolean bool = true; 
		for(int i=1; i<digits.length; i++){ 
			bool &=(Integer.parseInt(String.valueOf(digits[i-1]))-Integer.parseInt(String.valueOf(digits[i])))<0?true:false; 
		}
		return bool;
	} 
	private boolean checkReversed(int n) { 
		char[] digits = String.valueOf(n).toCharArray(); 
		boolean bool = true; 
		for(int i=1; i<digits.length; i++){ 
			bool &=(Integer.parseInt(String.valueOf(digits[i-1]))-Integer.parseInt(String.valueOf(digits[i])))>0?true:false; 
		} 
		return bool; 
	} 
	public static void main(String[] args) { 
		//		int n = 534976; 
		int n = 123321; 
		NextHighestNumber number = new NextHighestNumber(); 
		System.out.println(" Next Highest Number "+number.getNextHN(n)); 
	} 
}
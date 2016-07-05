package com.company.algo.core;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MinimumEditDistance {

	public Integer maximizeEditDistance(String a, String b){
		int max = Integer.MIN_VALUE;
		int[][] matrix = new int[a.length()+1][b.length()+1];
		for(int i=1; i<=a.length(); i++){
			for(int j=1; j<=b.length(); j++){
				matrix[i][j] = Math.max(0, Math.max(matrix[i-1][j]-1, Math.max(matrix[i][j-1]-1, matrix[i-1][j-1]+(a.charAt(i-1)==b.charAt(j-1)?1:-1))));
				if(matrix[i][j] > max)
					max = matrix[i][j];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String a = "atcat",b="attatc";
		MinimumEditDistance miDistance = new MinimumEditDistance();
		System.out.println(" Minimum Edit Distance "+ miDistance.maximizeEditDistance(a, b));
		
	}
}

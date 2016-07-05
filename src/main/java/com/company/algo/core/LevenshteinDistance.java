package com.company.algo.core;

public class LevenshteinDistance {

	public Integer estimateLevDist(String a, String b){
		int[][] matrix = new int[a.length()][b.length()];
		for(int i=0; i< a.length(); i++)
			matrix[i][0] = i;
		for(int j=0; j < b.length(); j++)
			matrix[0][j] = j;
		for(int i=1; i<a.length(); i++)
			for(int j=1; j<b.length(); j++)
				matrix[i][j] = Math.min(Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1),matrix[i-1][j-1]+(a.charAt(i-1)!=b.charAt(j-1)?2:0));
		return matrix[a.length()-1][b.length()-1];
	}
	
	public static void main(String[] args) {
		String a = "intention", b = "execution";
		LevenshteinDistance levDist = new LevenshteinDistance();
		System.out.println("Levenshtein distance "+ levDist.estimateLevDist(a, b));
	}
}

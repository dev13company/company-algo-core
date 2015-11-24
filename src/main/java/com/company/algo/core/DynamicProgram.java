package com.company.algo.core;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class DynamicProgram {

	public double cutRod(double[] p, int n){
		if(n==0)
			return 0;
		double q = Double.MIN_VALUE;
		for(int i=1; i< n; i++){
			q = Math.max(q, p[i-1]+cutRod(p, n-i));
			System.out.println(" Length "+q);
		}
		return q;
	}
	
	public double TopDownMemorizedCutROD(double[] p, int n){
		double[] r = new double[p.length];
		for(int i=0; i< r.length; i++){
			r[i] = -1;
			}
		return MemorizedCutRodAux(p,n,r);	
	}
	private double MemorizedCutRodAux(double[] p, int n, double[] r) {
		if(r[n] >= 0)
			return r[n];
		double q = 0;
		if(n==0){
			q = 0;
		}else{
			q = Double.MIN_VALUE;
			for(int i=1; i< n; i++)
				q = Math.max(q, p[i-1]+MemorizedCutRodAux(p, n-i, r));			
		}
		r[n]=q;
		return q;
	}

	public double BottomUpCutRod(double[] p,int n){
		double[] r = new double[p.length];
		r[0] = 0;
		for(int i=0; i< n; i++){
			double q = Double.MIN_VALUE;
			for(int j =0; j < i; j++){
				q = Math.max(q, p[i]+r[i-j]);				
			}
			r[i]=q;	
		}
		return r[n-1];
	}
	public static void main(String[] args) {
		double p[] = new double[40];
		for(int i=0; i< 40; i++){
			p[i] = Math.floor(Math.random()*10);
		}
		DynamicProgram dp = new DynamicProgram();
		System.out.println(" Original Array "+Arrays.asList(ArrayUtils.toObject(p)));
		System.out.println(" Maximum revenue "+dp.BottomUpCutRod(p,40));
	}
}
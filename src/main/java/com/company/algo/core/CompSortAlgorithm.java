package com.company.algo.core;

import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.ds.core.MaxHeap;

public class CompSortAlgorithm {

	private static Logger log = LoggerFactory.getLogger(CompSortAlgorithm.class);
	
	public static double[] iSort(double[] input){
		double[] output = new double[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		
		for(int i=1; i< output.length; i++){
			double x = output[i];
			int j = i;
			while(j>0 && output[j-1]> x){
				output[j] = output[j-1];
				j=j-1;
			}
			output[j]=x;
			}		
		return output;
		
	}
	
	public static double[] SSort(double[] input){
		double[] output = new double[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		int min;
		for(int i=0; i< output.length -1 ; i++){
			min =i;
			for(int j=i+1;j<output.length;j++){
				if(output[j]<output[min])
					min=j;
			}
			if(min!=i){
				double temp = output[i];
				output[i] = output[min];
				output[min]=temp;
			}				
		}		
		return output;
	}
	
	public static double[] BSort(double[] input){
		double[] output = new double[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		boolean swapped=true;
		int j=0;
		double tmp;
		while(swapped){
			swapped = false;
			j++;
			for(int i=0; i < output.length-j; i++){
				if(output[i]>output[i+1]){
					tmp = output[i];
					output[i]=output[i+1];
					output[i+1]=tmp;
					swapped = true;
				}
			}
		}		
		return output;
	}
	private static int N;
	
	public static double[] HSort(double[] input){
		double[] output = new double[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		heapify(output);
		N =output.length-1;
		for(int i=N; i>0; i--){
			double tmp = output[0];
			output[0]=output[i];
			output[i]= tmp;
			N=N-1;
			maxheap(output,0);
		}
		return output;
	}
	
	public static void maxheap(double arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
        log.info("Is max == i"+ (max==i));
        if (max != i)
        {
//            swap(arr, i, max);
            double tmp = arr[i];
			arr[i]=arr[max];
			arr[max]= tmp;
            maxheap(arr, max);
        }
    }  
	
	private static void heapify(double[] arr){
		N=arr.length-1;
		for(int pos = (N/2); pos >=0; pos--){
			maxheap(arr,pos);
			log.info(" Each Iteration "+ Arrays.asList(ArrayUtils.toObject(arr)));
		}
	}
	
	public static double[] MSort(double[] input){
		double[] output = new double[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		MergeSort(output, 0,output.length-1);
		return output;
	}
	
	public static double[] QSort(double[] input){
		double[] output = new double[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		QuickSort(output, 0,output.length-1);
		return output;
	}
	
	public static void QuickSort(double[] output, int lower, int upper){
		if(lower >= upper)
			return;
		double pivot = output[upper];
		int partition = partition(output, pivot,lower, upper);
//		log.info(" partition "+partition+" value "+ output[partition]);
		QuickSort(output, lower, partition-1);
		QuickSort(output, partition+1,upper);
	}
	private static int partition(double[] output, double pivot, int lower, int upper) {
		int left = lower-1;
		int right = upper;
		
		while(left < right){
			++left;
			log.info(" left "+left +" right "+right);
			while(output[left]<pivot){
				left++;
			}
			--right;
			while(right >0 && output[right]>pivot){
				--right;
			}
			if(left >=right)
				break;
			else{
				double temp = output[left];
				output[left] = output[right];
				output[right] = temp;
			}
				
		}
		double temp = output[left];
		output[left] = output[upper];
		output[upper] = temp;
		return left;
	}

	private static void MergeSort(double[] output, int lower, int upper) {
		if(lower < upper){
			int middle = lower+ (upper -lower)/2;
			MergeSort(output, lower, middle);
			MergeSort(output, middle+1, upper);
			Merge(output,lower,middle, upper);
		}
		
	}

	private static void Merge(double[] output, int lower, int middle ,int upper) {
//		int size = upper - middle +1;
		double[] tarr = new double[output.length];
		for(int i=lower;i<=upper;i++){
			tarr[i]=output[i];
		}
		int i = lower;
		int j = middle +1;
		int k = lower;
		while (i <= middle && j <= upper) {
            if (tarr[i] <= tarr[j]) {
                output[k] = tarr[i];
                i++;
            } else {
                output[k] = tarr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            output[k] = tarr[i];
            k++;
            i++;
        }		
	}

	public static int[] CSort(int[] input){
		int[] output = new int[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		int[] foutput = new int[input.length];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=0; i< output.length ; i++){
			if(output[i]<min)
				min = output[i];
			if(output[i]>max)
				max = output[i];
		}
		int[] count = new int[max+1];
		for(int j=0; j < output.length ; j++){
			count[output[j]] = count[output[j]]+1;
		}
		log.info(" Count Array 1 "+Arrays.asList(ArrayUtils.toObject(count)));
		for(int i=1; i<count.length; i++){
			count[i]=count[i] + count[i-1];
		} 
		log.info(" Count Array 2 "+Arrays.asList(ArrayUtils.toObject(count)));
		for(int j=output.length-1; j>0; j--){
			foutput[count[output[j]]-1] = output[j];
//			log.info(""+foutput[j]);
			count[output[j]] = count[output[j]]-1;
		}
		
		return foutput;
	}
	
	public static double[] RSort(double[] input){
		double[] output = new double[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		
		return output;
	}
	public static void main(String[] args) {
		double[] input = new double[10];
		int[] ninput = new int[10];
		for(int i=0; i< 10; i++){
			input[i]= Math.floor(Math.random()*10);
			ninput[i] = (int) Math.round(Math.random()*10);
		}
//		log.info(" Input Values "+ Arrays.asList(ArrayUtils.toObject(input)));
		log.info(" Input Values "+ Arrays.asList(ArrayUtils.toObject(ninput)));
		
		log.info(" Output Values "+ Arrays.asList(ArrayUtils.toObject(CompSortAlgorithm.CSort(ninput))));
		
		
	}
}
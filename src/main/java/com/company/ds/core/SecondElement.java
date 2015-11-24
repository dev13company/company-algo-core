package com.company.ds.core;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class SecondElement {

	public static Logger log = LoggerFactory.getLogger(SecondElement.class);

	public static int getSecondMinimumNonOptimized(int[] values) { 
		int min = -1, secondMin = -1; 
		int firstValue = values[0]; 
		int secondValue = values[1]; 
		if (firstValue < secondValue) { 
			min = firstValue; 
			secondMin = secondValue; 
		} 
		else { 
			min = secondValue; 
			secondMin = firstValue; 
		} 
		int nextElement = -1; 
		for (int i = 2; i < values.length; i++) { 
			nextElement = values[i]; 
			if (nextElement < min) { 
				secondMin = min; 
				min = nextElement; 
			} else if (nextElement < secondMin) { 
				secondMin = nextElement; 
			} 
		} 
		return secondMin; 
	}

	public static int[][] getDepthTree(int[] values){ 
		Integer size = values.length; 
		double treeDepth = Math.log(size.doubleValue())/Math.log(2); 
		int intTreeDepth = Double.valueOf(Math.ceil(treeDepth)+1).intValue(); 
		int[][] outputTree = new int[intTreeDepth][];
		outputTree[0] = values;
		int[] currentRow = values; 
		int[] nextRow = null; 
		for(int i = 1; i < intTreeDepth; i++){ 
			nextRow = getNextRow(currentRow); 
			outputTree[i] = nextRow; 
			currentRow = nextRow; 
			printRow(outputTree[i]); 
		} 
		return outputTree; 
	}

	private static void printRow(int[] values) { 
		for (int i : values) { 
			System.out.print(i + " "); 
		} 
		System.out.println(" "); 
	} 
	public static int getRootElement(int[][] tree) { 
		int depth = tree.length; 
		return tree[depth - 1][0]; 
	} 
	public static int getSecondMinimum(int[][] tree, int rootElement) { 
		int adjacentleft = -1, adjacentRight = -1; 
		int secondLeast = Integer.MAX_VALUE; 
		int rootIndex = 0; 
		int[] rowAbove = null; 
		// we have to scan in reverse order 
		for (int i = tree.length - 1; i > 0; i--) { 
			// one row above 
			rowAbove = tree[i - 1]; 
			System.out.println(" above row "+Arrays.asList(ArrayUtils.toObject(rowAbove))); 
			adjacentleft = rowAbove[rootIndex * 2]; 
			System.out.println(" Adjacent Left "+adjacentleft); 
			// the root element could be the last element carried from row above 
			// because of odd number of elements in array, you need to do 
			// following // check. if you don't, this case will blow {8, 4, 5, 6, 1, 2} 
			if (rowAbove.length >= ((rootIndex * 2 + 1) + 1)) { 
				adjacentRight = rowAbove[rootIndex * 2 + 1]; 
				System.out.println(" Adjacent Right "+adjacentRight); 
			} else { 
				adjacentRight = -1; 
			}
			// if there is no right adjacent value, then adjacent left must be 
			// root // continue the loop. 
			if (adjacentRight == -1) { 
				// just checking for error condition 
				if (adjacentleft != rootElement) { 
					throw new RuntimeException("This is error condition. Since there " + " is only one adjacent element (last element), " + " it must be root element");
				} else { 
					rootIndex = rootIndex * 2;
					continue; 
				} 
			}

			// one of the adjacent number must be root (min value). 
			// Get the other number and compared with second min so far 
			if (adjacentleft == rootElement && adjacentRight != rootElement) { 
				secondLeast = Math.min(secondLeast, adjacentRight); 
				rootIndex = rootIndex * 2; 
			} else if (adjacentleft != rootElement && adjacentRight == rootElement) { 
				secondLeast = Math.min(secondLeast, adjacentleft); 
				rootIndex = rootIndex * 2 + 1; 
			} else {
				throw new RuntimeException("This is error condition. One of the adjacent " + "elements must be root element"); 
			} 
		}
		return secondLeast; 
	} 
	private static int[] getNextRow(int[] values) { 
		int rowSize = Double.valueOf(Math.ceil(values.length/2)).intValue(); 
		int[] row = new int[rowSize]; 
		int i = 0; 
		for (int j = 0; j < values.length; j++) { 
			if (j == (values.length - 1)) { 
				// this is the case where there are odd number of elements 
				// in the array. Hence the last loop will have only one element. 
				row[i++] = values[j]; 
			} else { 
				row[i++] = Math.min(values[j], values[++j]); 
			} 
		} 
		return row; 
	}

	public static void main(String[] args) { 
		SecondElement sMinimum = new SecondElement(); 
		int[] values = {2,4,5,3,1,8,7,10}; 
		log.info(" The second minimum element in the array "+sMinimum.getSecondMinimumNonOptimized(values));
		// Get Tree and obtain the Minimum Element in the array 
		int[][] outputTree = getDepthTree(values); 
		int min = getRootElement(outputTree); 
		log.info("The least element "+min); 
		// Get Second Minimum (Optimized) 
		log.info("Second Minimum (Using optimized algorithm): " + getSecondMinimum(outputTree, min)); 
	} 
}
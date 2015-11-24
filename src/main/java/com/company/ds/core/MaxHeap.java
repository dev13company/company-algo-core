package com.company.ds.core;

public class MaxHeap {
	private double[] heap; 
	private int size; 
	private int maxsize; 
	private static final int FRONT=1; 
	public MaxHeap(int maxsize){ 
		this.maxsize = maxsize; 
		this.size = 0; 
		heap = new double[this.maxsize+1]; 
		heap[0] = Double.MAX_VALUE; 
	} 
	private int parent(int pos){ 
		return pos/2; 
	} 
	private int leftChild(int pos){ 
		return 2*pos; 
	} 
	private int rightChild(int pos){ 
		return (2*pos)+1; 
	} 
	private boolean isLeaf(int pos){ 
		if(pos >=(size/2) && pos<=size){ 
			return true; 
		} 
		return false; 
	} 
	private void swap(int fpos, int spos){ 
		double tmp = heap[fpos]; 
		heap[fpos] = heap[spos]; 
		heap[spos] = tmp; 
	} 
	private void maxHeapify(int pos){ 
		if(!isLeaf(pos)){ 
			if(heap[pos] < heap[leftChild(pos)]||heap[pos]<heap[rightChild(pos)]){ 
				if(heap[leftChild(pos)]>heap[rightChild(pos)]){ 
					swap(pos, leftChild(pos)); 
					maxHeapify(leftChild(pos)); 
				}else{ 
					swap(pos, rightChild(pos)); 
					maxHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 
	public void insert(int element){ 
		heap[++size] = element; 
		int current = size; 
		while(heap[current]>heap[parent(current)]){ 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
		print(); 
		try { 
			Thread.sleep(1000l); 
		} catch (InterruptedException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
	} 
	public void maxHeap(){ 
		for(int pos = (size/2); pos >=1; pos--){ 
			maxHeapify(pos); 
		} 
	} 
	public void print() { 
		for (int i = 1; i <= size / 2; i++ ) {
			System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i] + " RIGHT CHILD :" + heap[2 * i + 1]); 
			System.out.println(); 
		} 
	}
	public static void main(String[] args) { 
		MaxHeap maxHeap = new MaxHeap(15); 
		maxHeap.insert(5); 
		maxHeap.insert(3); 
		maxHeap.insert(17);
		maxHeap.insert(10); 
		maxHeap.insert(84); 
		maxHeap.insert(19); 
		maxHeap.insert(6); 
		maxHeap.insert(22); 
		maxHeap.insert(9); 
		maxHeap.maxHeap(); 
		maxHeap.print(); 
	} 
}